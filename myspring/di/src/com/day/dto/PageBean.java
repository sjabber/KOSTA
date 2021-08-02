package com.day.dto;

import java.util.List;

public class PageBean<T> {
    private int currentPage = 1;
    private int totalPage;
    /**
    �럹�씠吏�蹂� 蹂댁뿬以� 紐⑸줉 �닔
    **/
    public static final int CNT_PER_PAGE = 10;
    public List<T> list; //type generic

   /**
    �럹�씠吏�洹몃９�쓽 �럹�씠吏� �닔
    **/
   public static int CNT_PER_PAGE_GROUP = 4;
   private int startPage = 1;
   private int endPage;

   private String url;
   public PageBean() {};
   public PageBean(int currentPage, int totalPage, List<T> list, String url) {
       this.currentPage = currentPage;
       this.totalPage = totalPage;
       this.list = list;
       this.url = url;

		/*
		 * this.startPage = ~~~; this.endPage = ~~~;
		 */
   }

   public int getCurrentPage() {
       return currentPage;
   }
}
