# Dog-Vote-Application
Redis와 Kafka, Spring를 활용한 강아지 인기투표 아키텍쳐 만들기
<img width="972" alt="image" src="https://github.com/worldii/Dog-Vote-Application/assets/87687210/8331a255-4cf4-4321-9aa5-2c64a266b5a3">

# 기술 스택
### BackEnd
<img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=Java&logoColor=#007396" style="height : auto; margin-left : 10px; margin-right : 10px;"/><img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white" style="height : auto; margin-left : 10px; margin-right : 10px;"/><img src="https://img.shields.io/badge/Redis-000000?style=for-the-badge&logo=Redis&logoColor=white" style="height : auto; margin-left : 10px; margin-right : 10px;"/> <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white" style="height : auto; margin-left : 10px; margin-right : 10px;"/> <img src="https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=Gradle&logoColor=white" style="height : auto; margin-left : 10px; margin-right : 10px;"/>
  <img src="https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=black">
<img src="https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=Hibernate&logoColor=white">

### FrontEnd
 <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"><img src="https://img.shields.io/badge/html-E34F26?style=for-the-badge&logo=html5&logoColor=white">
  <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white">
  <img src="https://img.shields.io/badge/axios-007CE2?style=for-the-badge&logo=axios&logoColor=white" >
  <img src="https://img.shields.io/badge/bootstrap-1572B6?style=for-the-badge&logo=bootstrap&logoColor=white">
  <img src="https://img.shields.io/badge/vuejs-E34F26?style=for-the-badge&logo=vuejs&logoColor=white">

### 기타
  <img src="https://img.shields.io/badge/vim-%23121011.svg?style=for-the-badge&logo=vim&logoColor=white"><img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=Docker&logoColor=white" style="height : auto; margin-left : 10px; margin-right : 10px;"/>

Spring Boot, Spring JPA, Mysql, Redis, Kafka,  Vue
# 구현한 것들

- [x]  전체 목록 조회
    - [x]  페이지 네이션
    - [x]  Simple 정보 가져옴
    - [ ]  레디스 방식
    - [ ]  필터 정렬 기능
- [x]  상세 정보 조회
    - [x]  레디스 확인 후, 있으면 보여주고 없으면 레디스에 저장.
    - [x]  detail 정보를 가져옴.
- [x]  투표 하기, 투표 취소 하기
    - [x]  Kafka 를 이용한 구현  (Vote, Unvote 토픽 알림)
    - [x]  이벤트 내용을 통해 강아지의 투표 값을 mysql 에  업데이트 함.
    - [x]  레디스에 이에 대한 내용이 있다면, 이를 또 갱신함.
    - [ ]  중복 투표 방지 위해 방법 마련( 헤더, 이메일 등)
- [ ]  CQRS 패턴

# 실행 방법
## frontend
npm run serve
##  backend
###  redis
docker run --name some-redis -d -p 6379:6379 redis
<br>
docker run -it --link some-redis:redis --rm redis redis-cli -h redis -p 6379
<br>
### kafka
dogVoteAPI/docker-compose.yml 실행 <br>
docker-compose up -d
