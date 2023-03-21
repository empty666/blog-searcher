Blog Searcher Application
==========================


카카오와 네이버 블로그 조회 API를 활용하여 포스트를 검색할 수 있으며,  
사용자가 검색에 사용 한 키워드를 관리하여 가장 많이 사용 된 검색 키워드를 조회할 수 있는 기능을 제공합니다.


**Github Repository URL : https://github.com/empty666/blog-searcher.git**  
**Jar File Download Link : https://github.com/empty666/blog-searcher/raw/master/jars/searcher-api-1.0-SNAPSHOT.jar**
- - -
- - -
## API Guide
Blog Searcher에서 제공하는 API의 목록과 정보입니다.
- - -
### 블로그 검색

* 검색어를 이용하여 블로그 포스트를 조회 합니다.
  * URL : /blog-search/v1/search (GET)
  * Parameters
    * page (Integer) : 요청 페이지 Index
    * size (Integer) : 한 페이지에 표시 할 컨텐츠 개수
    * query (String) : 검색을 위한 질의어. n개의 질의어는 콤마(,)를 이용하여 구분
    * sort (SortType) : 정확도, 최신순 정렬을 제공하며 값이 없는 경우 정확도를 기본값으로 사용
      * ACCURARY : 정확도 기준 정렬
      * NECENCY : 최신순 정렬
  * Response
```json
{
  "pagination": {
  "totalCount": 445,
    "totalPage": 445,
    "offset": 1,
    "size": 1
  },
  "documents": [
    {
        "title": "Apple 신형 AirPods <b>맥스</b>, <b>홈팟</b> 미니, 저가 <b>에어</b><b>팟</b> 2024년 하반기 양산 시작",
        "description": "분석가 궈밍치는 애플이 2024년 하반기부터 어쿠스틱 오디오 제품을 새로 고칠 것으로 기대한다고 말했다. 구체적으로 Kuo는 <b>에어</b><b>팟</b> <b>맥스</b>의 새로운 모델과 2세대 <b>홈팟</b> 미니, 그리고 저가형 <b>에어</b><b>팟</b> 모델이 양산에 들어갈 것으로 예상하고 있다. 이 제품들의 출하는 2024년 말에서 2025년 상반기 사이에 고객들에게 출시될...",
        "linkUrl": "http://seewebtv.tistory.com/1871",
        "blogName": "IT 최신 소식 블로그 임프레션 SEEWEB TV",
        "updatedAt": "2023-02-17T13:51:16.000+00:00"
    }
  ]
}
```

---
### 검색 키워드 조회
* 사용자가 가장 많이 검색에 활용 한 키워드 상위 10개를 조회 합니다.
    * URL : /recent-keyword/v1/top-10 (GET)
    * Parameters : NONE
    * Response
```json
[
  {
    "keyword": "에어팟맥스",
    "hitCount": 10
  },
  {
    "keyword": "에어팟",
    "hitCount": 10
  },
  {
    "keyword": "홈팟",
    "hitCount": 10
  }
]
```
- - -

