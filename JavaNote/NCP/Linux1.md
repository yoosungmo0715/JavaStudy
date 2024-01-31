# 리눅스 update

**1. 프롬프트 기호**
```
# => 관리자  
$ =? 일반 사용자
```
**2. 패키지 업데이트**
```
# apt update => 이미 관리자이기 때문에 그냥 update 가능
$ sudo apt update => 일반사용자이기 때문에 sudo를 붙여주어야 한다.
```

*sudo(super user do): 관리자 권한으로 실행

# 리눅스 사용자 추가
**1. 사용자 추가**
```
// 사용자를 생성하면서 필요한 작업을 자동으로 처리(홈 디렉토리, 초기 설정)
# adduser 사용자명

// 사용자만 추가하기 때문에 사용자가 직접 설정해주어야 한다.
# useradd 사용자명
```

**2. 사용자에게 관리자 권한 부여**
```
# usermod -aG sudo 사용자명
```
