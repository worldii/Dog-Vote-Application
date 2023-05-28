# Dog-Vote-Application
Redis와 Kafka, Spring를 활용한 강아지 인기투표 아키텍쳐 만들기
<img width="972" alt="image" src="https://github.com/worldii/Dog-Vote-Application/assets/87687210/8331a255-4cf4-4321-9aa5-2c64a266b5a3">

# 기술 스택
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

