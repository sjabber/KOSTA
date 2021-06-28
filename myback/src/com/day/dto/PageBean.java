package com.day.dto;

import java.util.List;

public class PageBean<T> {
    private int currentPage = 1;
    private int totalPage;
    /**
    페이지별 보여줄 목록 수
    **/
    public static final int CNT_PER_PAGE = 10;
    public List<T> list; //type generic

   /**
    페이지그룹의 페이지 수
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

       this.startPage = ~~~;
       this.endPage = ~~~;
   }

   public int getCurrentPage() {
       return currentPage;
   }
}
