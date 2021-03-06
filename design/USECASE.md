# 요구사항 분석 문서

## 1. 프로젝트 범위 (초기 배포)

- 로그인 X

- 방 만들기
- 방 입장
- 방장 - 링크 생성, 링크를 통해 초대 가능, 게임 시작시킬 수 있음
- 참가자 - 링크를 통해 입장 가능, 

## 1) 초기화면

- 방 만들기 버튼
  - 방 생성
  - 최대 인원 설정 (4 ~ 8 인)
- 로그인 X 



## 2) 게임 방

#### (1) 게임 시작 전

- 방 입장 전 닉네임 설정 팝업창
- 게임 초대 버튼
  - 미팅룸 url 복사
  - (같이 게임할 사람에게 링크 공유)
  - 방장, 참가자 모두 사용 가능
- 게임 시작(준비) 버튼
  - 방장 - 모든 참가자가 준비 완료 상태일 때 게임 시작 가능
  - 참가자 - 준비 완료 / 취소 가능
- 예외처리
  - 방장이 나가면 임의의 다른 사용자에게 방장 권한 위임
  - 게임이 시작되면 해당 링크로 접속할 수 없다.

#### (2) 게임 진행

1. 역할 공지

- 직업 랜덤 배정 기능

  - 4 ~ 5명
    - 마피아: 1
    - 의사: 1
    - 시민: 전체 - 2

  - 6 ~ 8명
    - 마피아: 2
    - 의사: 1
    - 시민: 전체 - 3

- 직업 공지 기능
  - 알림 팝업 형태로 직업 공지
  - 마피아: "~~~님, @@@님은 마피아입니다."
  - 의사 : "~~~님은 의사입니다."
  - 시민: "~~~님은 시민입니다."

2. 게임 시작

- 낮
  - 자유로운 이야기 ==> 투표 ==> 최후의 변론 ==> 사형 투표 ==> 밤
  - 자유로운 이야기
    - 시간: 2분
  - 투표
    - 시간: 15초 (제한된 시간안에 투표를 하지 않으면 무효표로 처리)
    - 투표 방식: 마피아일거라고 생각하는 사용자의 프로필을 클릭하면 투표, 무효표도 가능(skip)
    - 투표 확인 방식: 프로필 밑에 해당 사용자를 선택한 사용자의 닉네임 표시
    - 동률일 경우, 그날 낮으로 돌아간다.
  - 최후의 변론
    - 시간: 10초
    - 최다 득표자만 켠다. (나머지는 음소거)
  - 사형 투표
    - 시간: 15초
    - 투표 방식: 팝업 형태로 찬성 / 반대 버튼이 표시("~~~님의 사형 집행에 찬성하십니까?")
    - 투표 확인 방식: 투표자의 프로필 밑에 찬성 / 반대 표시
    - 과반 이상 찬성시 사형
    - 동률이면 사형 집행 X
- 밤
  - 마피아 투표 ==> 의사 투표 ==> 낮
  - 카메라 및 마이크 세팅
    - 마피아: 마피아끼리 카메라, 마이크 사용 가능
    - 의사 및 시민: 본인 빼고 카메라, 마이크 음소거
  - 마피아 투표
    - 시간: 15초
    - 투표 방식: 죽이고 싶은 시민 사용자 프로필을 클릭하면 투표, 무효표도 가능(skip)
    - 투표 확인 방식: 프로필 밑에 해당 사용자를 선택한 사용자의 닉네임 표시 (마피아에게만 보임)
    - 동률일 경우, 아무도 죽이지 못함. (의사 투표 시간에 마피아들에게 선택을 하지 못해서 아무도 죽이지 못한다는 메세지 보내기)
  - 의사 투표
    - 시간: 15초
    - 투표 방식: 살리고 싶은 사용자 프로필을 클릭하면 투표, 무효표도 가능(skip)
    - 투표 확인 방식: 프로필 밑에 해당 사용자를 선택한 사용자의 닉네임 표시(의사에게만 보임)
    - 의사가 없는 경우엔 이 단계 넘어감
  - 마피아 투표와 의사 투표에 따른 결과
    - 마피아 투표가 유효한 경우
      - 마피아 투표 == 의사 투표: 아무도 죽지 않음
      - 마피아 투표 != 의사 투표: 마피아가 선택한 사용자 죽음
    - 마피아 투표가 유효하지 않은 경우
      - 아무도 죽지 않음
    - 누군가가 죽은 경우: '{직업} 인 ~~~ 님이 사망하셨습니다.'
    - 누군가가 죽지 않은 경우: '아무도 죽지 않았습니다.'
- 게임 종료 조건
  - 종료 조건은 낮이 끝나거나 밤이 끝나거나 누군가가 퇴장했을 때마다 체크한다.
  - 모든 마피아가 죽은 경우: 시민 승리
  - 생존자 중에 마피아 수 >= (시민 + 의사) 인 경우: 마피아 승리
  - 게임 종료 시 메세지: "시민(마피아) 승리"
    - 어느 팀이 승리했는지 보여주고 각자의 직업을 알려준다.

- 사망자
  - 카메라와 마이크 비활성화
  - 채팅 사용 가능
  - 게임을 진행하고 있는 사용자들의 직업을 보여줌
- 채팅 기능
  - 게임을 진행하고 있는 사용자: 사용 X 
  - 사망자: 사용 O

- 중간에 퇴장한 사람은 사망한 것으로 간주하고 게임 진행
