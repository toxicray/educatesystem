package com.imoocstruct.unionfind;

/**
 * Package:com.imoocstruct.unionfind
 * *Author:ray
 * *version:...
 * *Created in 2020/4/4  17:49
 **/
public interface UF {

	int getSize();

	void unionElements(int p,int q);

	boolean isConnected(int p,int q);
}
