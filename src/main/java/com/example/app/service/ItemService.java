package com.example.app.service;

import java.util.List;

import com.example.app.domain.Item;

public interface ItemService {

	List<Item> getAll();

	Item getOneById(int id); // 資材IDを元に1件分の資材情報を返す

	// 場所IDを元に、ID、品名、総数、購入日、備考のリストを返す
	List<Item> getByRoomId(String roomId);

	// 引数としてページ番号を渡すと、そのページに該当する資材リストを返す
	List<Item> getByPage(int page);

	// 引数として場所ID とページ番号を渡すと、その場所とページに該当する資材リストを返す
	List<Item> getByRoomIdAndPage(String roomId, int page);

	// １ページあたりのデータ取得件数を設定する
	void setNumPerPage(int numPerPage);

	// １ページあたりのデータ取得件数を返す
	int getNumPerPage();

	// 全資材リストを表示するにあたって必要なページ数を返す
	int getTotalPages();

	// 場所IDで絞り込んだ資材リストを表示するにあたって必要なページ数を返す
	int getTotlaPagesByRoomId(String roomId);
	
	// 資材ID を元に、資材情報の削除を⾏う
	void deleteById(int id);
	
}
