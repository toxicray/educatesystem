package com.ray.educatesystem.concurrency;

import com.sun.xml.internal.ws.util.CompletedFuture;
import org.junit.Test;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Package:com.ray.educatesystem.concurrency
 * *Author:ray
 * *version:...
 * *Created in 2019/11/17  1:22
 **/
public class FutureTaskDemo01 {
	public static void main(String[] args) {
		FutureTask<Integer> futureTask = new FutureTask<>(() -> 1 + 2);
		ExecutorService executorService = Executors.newCachedThreadPool();
		//Future<?> submit = executorService.submit(futureTask);
		try {
			Future<?> submit1 = executorService.submit(futureTask);
			System.out.println(futureTask.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		executorService.shutdown();
	}


	@Test
	public void testThread() throws ExecutionException, InterruptedException {
		FutureTask<Integer> futureTask = new FutureTask<>(() -> 1 + 2);
		Thread thread = new Thread(futureTask);
		thread.start();
		System.out.println(futureTask.get());
	}
	@Test
	public void testThread12() throws ExecutionException, InterruptedException {
		String str="haha";
		CompletableFuture<Void> task=CompletableFuture.runAsync(()->{
			System.out.println(str);
		});
		//task.join();
		task.get();
	}

	@Test
	public void testMakeTea() throws ExecutionException, InterruptedException {

		ExecutorService executorService = Executors.newCachedThreadPool();

		FutureTask<String> task2 = new FutureTask<String>(new T2Task());
		FutureTask<String> task1 = new FutureTask<String>(new T1Task(task2));
		executorService.submit(task1);
		executorService.submit(task2);
		System.out.println(task1.get());
		System.out.println(Thread.currentThread().getName());
	}

	@Test
	public void testCompleteAbleFuture() throws ExecutionException, InterruptedException {
		CompletableFuture<Void> task1 = CompletableFuture.runAsync(() -> {
			System.out.println("T1: 洗水壶");
			//Thread.sleep(1000);
			sleep(1);
			System.out.println("T1; 洗水杯");
			sleep(2);
			System.out.println("T1: 烧开水");
			sleep(2);
			printThreadName();
		});

		CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
			System.out.println("T2: 洗茶壶");
			sleep(1);
			System.out.println("T2: 拿茶叶");
			sleep(2);
			printThreadName();
			return "龙井";
		});


		CompletableFuture task3 = task1.thenCombine(task2, (__, tf) -> {
			System.out.println("T1: 拿到茶叶--" + tf);
			System.out.println("T1: 泡茶--");
			printThreadName();
			return "上茶:" + tf;
		});

		System.out.println(task3.get());
		printThreadName();
	}

	private void sleep(int time) {
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void printThreadName(){
		System.out.println(Thread.currentThread().getName());
	}



	@Test
	public void test串行() throws ExecutionException, InterruptedException {
		CompletableFuture task1=CompletableFuture.runAsync(()->{
			sleep(3);
			System.out.println("我是任务一");
			printThreadName();

		});
		CompletableFuture task2=CompletableFuture.runAsync(()->{
			sleep(2);
			System.out.println("我是任务二");
			printThreadName();

		});
		CompletableFuture task3=CompletableFuture.runAsync(()->{
			sleep(1);
			System.out.println("我是任务三");
			printThreadName();
		});
		task1.thenAccept((tf)->{
			printThreadName();
			try {
				task2.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}).thenAccept(tf->{
			printThreadName();
			try {
				task3.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}).get();
	}

	@Test
	public void test串行2() throws ExecutionException, InterruptedException {
		CompletableFuture<String> task=
				CompletableFuture
						.supplyAsync(()->"hello world")
				.thenApply(s->s+"酒批")
				.thenApply(String::toUpperCase);
		System.out.println(task.get());
	}

	@Test
	public void testOR汇聚(){

		CompletableFuture<Integer> future = CompletableFuture
				.supplyAsync(() ->{
				int time= getRandom(10 );
				sleep(time);
				printThreadName();
				return time;
				});
		CompletableFuture<Integer> future1 = CompletableFuture
				.supplyAsync(() ->{
					int time= getRandom(10 );
					sleep(time);
					printThreadName();
					return time;
				}).exceptionally((throwable)->{
					System.out.println(throwable.getMessage());
					return 0;
				});
		CompletableFuture<Integer> f3=future.applyToEither(future1,(t)->{
			printThreadName();
			return t;
		} );
		System.out.println(f3.join());
	}

	private int getRandom(int i) {
		Random random=new Random();
		return random.nextInt(i);
	}




	@Test
	public  void testBlockAsync(){
		ExecutorService executor = Executors.newFixedThreadPool(3);// 异步向电商S1询价Future f1 = executor.submit( ()->getPriceByS1());// 异步向电商S2询价Future f2 = executor.submit( ()->getPriceByS2());// 异步向电商S3询价Future f3 = executor.submit( ()->getPriceByS3()); // 获取电商S1报价并保存r=f1.get();executor.execute(()->save(r)); // 获取电商S2报价并保存r=f2.get();executor.execute(()->save(r)); // 获取电商S3报价并保存 r=f3.get();executor.execute(()->save(r));

	}



	@Test
	public void testStreamSort(){
		Random random=new Random();
		List<student> list=new ArrayList();
		for (int i = 0; i < 10; i++) {
			student s=new student(random.nextInt(10),i+"");
			if (i==5){
			    s.setAge(null);
			}
			list.add(s);
		}
		list=list.stream().sorted(Comparator.comparingInt(student::getAge)).collect(Collectors.toList());
		list.stream().forEach(System.out::println);
	}

	@Test
	public void testLamda(){
		//String s = testSupplier(() ->
		//		//		"hello"
		//		//);
		//		//System.out.println(s);

	}


	private String testSupplier(Supplier<String> supplier){
		return supplier.get();
	}

	private Supplier<String> testSupplier1(Supplier<String> supplier){
		return supplier;
	}

	class student {
		private Integer age;
		private String name;

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public student(Integer age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public String toString() {
			return "student{" +
					"age=" + age +
					", name='" + name + '\'' +
					'}';
		}
	}


}
