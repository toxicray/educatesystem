package com.imoocstruct.unionfind;

/**
 * Package:com.imoocstruct.unionfind
 * *Author:ray
 * *version:...
 * *Created in 2020/4/4  17:55
 **/

/**
 * 关联的复杂度是O(n)    查找的复杂度是O(1)
 */
public class UnionFindOne implements UF {

	private int[] id;

	public UnionFindOne(int size) {
		this.id = new int[size];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}

	@Override
	public int getSize() {
		return id.length;
	}

	/**
	 * 将p和q相关的元素放置到同一个集合中
	 * @param p
	 * @param q
	 */
	@Override
	public void unionElements(int p, int q) {
		int pId = find(p);
		int qId = find(q);
		if(pId == qId){
			return;
		}
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pId){
				id[i] = qId;
			}
		}
	}

	@Override
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

	/**
	 * 查找元素所对应的集合编号
	 * @param p
	 * @return
	 */
	private int find(int p){
		if(p < 0 || p >id.length){
			throw new IllegalArgumentException(p+"is outofindex");
		}
		return id[p];
	}
}
