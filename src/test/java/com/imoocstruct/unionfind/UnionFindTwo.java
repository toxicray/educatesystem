package com.imoocstruct.unionfind;

/**
 * Package:com.imoocstruct.unionfind
 * *Author:ray
 * *version:...
 * *Created in 2020/4/4  18:49
 **/

/**
 * 特殊的树机构   并查集,查询关联关系,关联数据
 */
public class UnionFindTwo implements UF {

	private int[] parent;

	public UnionFindTwo(int size) {
		this.parent = new int[size];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}

	@Override
	public int getSize() {
		return parent.length;
	}

	@Override
	public void unionElements(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if(pRoot == qRoot){
			return;
		}
		parent[pRoot] = qRoot;
	}

	@Override
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

	private int find(int p) {
		if (p < 0 || p >= parent.length)
		while (p != parent[p]) {
			p = parent[p];
		}
		return p;
	}
}
