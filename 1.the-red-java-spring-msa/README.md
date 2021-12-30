
# 1. 개요

<details> <summary> 1. intro </summary>

## 1. intro

### 개발자의 존재 가치 
- 뉴욕타임즈 CTO
  - 기술조직은 회사의 비즈니스 지표에 따라 평가되어야 한다.
- 배달의 민족 CTO
  - 좋은 개발자의 덕목은 기술로서 비즈니스의 성공을 도울 수 있는 사람이다.
- 기술은 비즈니스 가치를 만들어 낼 수 있어야 존재 가치가 있다는 생각
  - 기술 선택의 기준이 현재와 가까운 미래의 비즈니스를 고려한 것인지
  - 또는 본인이 하고 싶어서, 요즘 유행하고 hip 하게 보인다는 이유로 선택하는지

### Microservice Architecture 의 정의
- 비즈니스 도메인을 중심으로 서비스를 모델링하고 구현하는 아키텍처 스타일
  - vs monolithic: 하나의 프로젝트 구조 안에서 모든 도메인을 구현하는 방식
- 도메인 서비스 간의 통신은 네트워크 기반의 HTTP API 또는 비동기 메시징 방식 등으로 이루어짐
- 각 도메인 서비스는 자체 Database를 가짐

### Microservice Architecture 전환을 고려해야 하는 시점
- 생존을 걱정하던 초기 스타트업에서 벗어나 비즈니스 규모가 어느 정도 궤도에 오르는 시점
- monolithic 구조의 장점보다 단점이 부각되는 시점
  - 하나의 repository에 코드베이스가 개개인이 감당할 수 없는 수준으로 커짐
  - 이에 따라 코드 파악과 유지보수가 어려워짐
  - 구현과 테스트, 배포의 속도가 점점 느려지고 정기배포라는 절차가 생김
  - 모든 측면에서의 확장성이 떨어지게 됨
-> monolithic의 단점이 부각되는 시점에서 현 상황을 변화시키지 않는다면, 기업 경쟁력은 점차 약화되고 길게 보면 생존하지 못할 수도 있다 

### Microservice Architecture의 장점과 단점
- 우버가 msa를 도입한 이유 -> 확장성 개선 
  - 증가하는 트래픽 처리
  - 새로운 기능을 쉽게 추가
  - 조직의 성장에 쉽게 적응할 수 있는 아키텍처 적용
- 장점
  - 각각의 비즈니스 도메인별로 독립적인 서비스를 운영할 수 있다
  - 빠른 구현과 배포가 가능해진다
  - 팀의 책임과 자율성이 극대화된다
- 단점
  - 네트워크 기반의 API 호출로 서비스가 구성되기 때문에 프로세스간 통신에 비해 느리고 복잡하다
  - 일관된 트랜잭션과 데이터 정합성을 유지하기 어렵다
  - 테스트와 장애추적, 모니터링 등이 쉽지 않다

### 소개
#### 목표 수강생
- 빠르게 성장하는 스타트업에서 일하는 개발자
- java / spring 으로 개발하는 실무 개발자
- 회사의 전체 서비스가 모놀리틱에서 msa로 전환하는 과정에 있는 개발자
- 팀 내에 시니어 개발자 또는 동료 개발자가 없이 혼자 일하는 개발자
- 다양한 요구사항 속에서 적절한 의사 결정을 기반으로 개발하는 싶은 개발자

### 구성 방향
1. 주문 도메인의 보편적인 요구사항을 실제 프로젝트로 구현함
    - 도메인 주도 설계 (이하 DDD) 개념을 개략적으로 풀어가면서 실제적인 코드 구현을 설명하고자 함
    - 크게 두개의 프로젝트를 코드로 구현할 예정
      - 주문 도메인 프로젝트
      - 선물하기 프로젝트
      - 처음에는 주문 도메인 개발, 이후 주문 도메인과 api를 주고 받으며 운영될 선물하기 서비스 개발을 진행할 예정
    - 라이브 코딩으로 코드 전체를 구현하는 것은 목적 대비 시간 소요가 많을 것이라, 미리 구현한 프로젝트를 활용하여 붙여넣기와 라이브 코딩을 섞어 가면서 진행할 예정 -> 정해진 시간 대비 내용 전달에 충실한 방법으로 진행할 예정
    - 동일한 맥락으로 테스트 코드는 일부만 작성함 -> 현업에서는 꼭 필요한 것이니 여기에서는 정해진 시간 내에서 내용 전달을 위해 일부 생략함
2. msa 전환과 설계, 구현에 대한 이론과 경험 중심의 소개
    - msa 전환을 위한 내부 구성원 설득
    - 시스템을 점진적으로 msa으로 전환하는 방법
    - 서버간 통신에 대한 여러가지 방법
    - 대용량 트래픽 처리를 위한 여러가지 방법 등등

### 참고 서적
- 도메인 주도 설계 / 에릭 에반스 / 위키북스
- 마이크로서비스 패턴 / 크리스 리처드슨 / 길벗
- 마이크로서비스 도입 이렇게 한다 / 샘 뉴먼 / 책만
- 마이크로서비스 아키텍처 구축 / 샘 뉴먼 / 한빛미디어
- 오브젝트 / 조영호 / 위키북스
- 클린 소프트웨어 / 로버트 C. 마틴 / 제이펍
- 클라우드 네이티브 패턴 / 코넬리아 데이비스 / 에이콘
- gRPC 시작에서 운영까지 / 카순 인드라시리 외 / 에이콘

</details>

# 2. 프로젝트 구조 및 설계

<details><summary> 1. 프로젝트 구조 및 설계 </summary>

## 1. 프로젝트 구조 및 설계

### 좋은 구현이란

#### 1. 비즈니스 가치를 명확히 충족시켜야 한다
- 뉴욕타임즈 CTO 의 4년 회고 - "기술조직은 회사의 비즈니스 지표에 따라 평가되어야 한다"
- 회사의 목표와 상관없이 기술적 성취에만 관심을 가지는 개발자의 가치는 얼마나 인정 받을 수 있을까?
- 유저의 경험과 회사의 목표보다는 본인이 사용하게 될 기술 스택에 대한 관심만 높은 개발자가 있다면, 스스로 마인드를 바꿔야 한다고 말하고 싶다
  - 기술은 도구일 뿐이다
  - 도구에 익숙해지고 좀 더 좋은 도구를 찾는 근원적인 이유도 비즈니스 목표 달성을 위한 것이어야 한다

#### 2. 잘 읽혀야 한다.
- 개발 업무를 단순히 코드 읽기와 쓰기로 분류해본다면 [읽기:쓰기] = [8:2] 정도의 비중이 되지 않을까 생각한다
  - 그만큼 코드 자체의 가독성이 좋아야 업무 효율을 지속적으로 높게 유지할 수 있다.
- 도메인 로직을 설명하는 별도의 문서보다는 코드 자체로 도메인을 파악할 수 있어야 한다.
- 물론 시스템 전체의 아키텍쳐, 데이터 flow, 코드로 표현할 수 없는 외부 요소들 (외부 연동 회사 정보, 최적화를 위한 코드 설명 등)은 별도의 기술문서로 표현하는 것이 맞다

#### 3. 테스트 코드 작성이 쉬워야 한다
- 테스트 코드는 지속적인 기능 런칭과 리펙토링을 가능하게 해주는 안전장치이다
- 코드간의 의존성이 많다면 그만큼 테스트 코드 작성이 어렵다
- 테스트 코드 작성이 쉬운 코드는 대체적으로 코드 품질이 좋은 편이다

#### 4. 변경에 유연해야 한다
- 요구사항은 언제든지 추가되고 바뀔 수 있다. 이는 너무도 당연한 것임을 인지해야 한다.
- 그렇기 떄문에 코드 구현과 설계는 요구사항 변경에 유연하도록 작성되어야 한다.
- 이를 가능하게 하는 여러가지 객체지향 설계 원칙이 존재한다. 이를 잘 알고 적용하는 것이 좋다.
  - 단일 책임 원칙 (SRP)
  - 개방 폐쇄 원칙 (OCP)
  - 리스코프 치환 원칙 (LSP)
  - 의존 관계 역전 원칙 (DIP)
  - 인터페이스 분리 원칙 (ISP)

### 도메인 주도 설계
마이크로 서비스 아키텍처의 컨셉을 생각하면 비즈니스 도메인 중심으로 서비스를 모델링하고 구현하는 것이 중요하다.  
이 때 각각의 복잡한 도메인을 모델링하고 표현력있게 설계하는 것을 도메인 주도 설계 (이하 DDD) 라고 한다.   
여기에서는 DDD의 개념을 개략적으로 풀어가면서 DDD에서 권장하는 개발 방식으로 실제적인 코드 구현을 설명하고자 한다.  

### 진행할 프로젝트의 Layer 구조
도메인 주도 설계에서 말하는 일반적인 엔터프라이즈 애플리케이션 레이어 구성을 참고한다. (도메인 주도 설계 72p 참고)  
레이어간의 참조 관계에서는 **단방향 의존을 유지**하고 계층간 호출에서는 인터페이스를 통한 호출이 되도록 한다.  

Layer 별 특징과 역할, 참조 관게는 다음과 같다.

**Layer 별 특징과 역할**  

|Layer|Description|여기에서 제시하는 주요 객체|
|-----|-----------|-----------------|
|사용자 인터페이스(Interface)|사용자에게 정보를 보여주고 사용자의 명령을 해석하는 책임을 진다.|Controller, Dto, Mapper(Converter)|
|응용 계층(application)|수행할 작업을 정의하고 표현력 있는 도메인 객체가 문제를 해결하게 한다. 이 계층에서 책임지는 작업은 업무상 중요하거나 다른 시스템의 응용 계층과 상호 작용하는 데 필요한 것들이다. 이 계층은 얇게 유지되고, 오직 작업을 조정하고 아래에 위치한 계층에 포함된 도메인 객체의 협력자에게 작업을 위임한다.|Facade|
|도메인 계층(domain)|업무 개념과 업무 상황에 대한 정보, 업무 규칙을 표현하는 일을 책임진다. 이 계층에서는 업무 상황을 반영하는 상태를 제어하고 사용하며, 그와 같은 상태 저장과 관련된 기술적인 세부사항은 인프라 스트럭쳐에 위임한다. 이 계층이 업무용 소프트웨어의 핵심이다.|Entity, Service, Command, Criteria, Info, Reader, Store, Executor, Factory(Interface)|
|인프라 스트럭쳐 계층(infrastructure)|상위 계층을 지원하는 일반화된 기술적 기능을 제공한다. 이러한 기능에는 애플리케이션에 대한 메시지 전송, 도메인 영속화, UI에 위젯을 그리는 것 등이 있다.|low level 구현체(ReaderImpl, StoreImpl, Spring JPA, RedisConnector, ...)|

### Layer 간 참조 관계 
- Layer 간의 참조 관계에서 application과 Infrastructure는 domain layer를 바라보게 하고 양방향 참조는 허용하지 않게 한다.
- domain layer는 low level의 기술에 상관없이 독립적으로 존재할 수 있어야 한다. 
  - 이를 위해 대부분의 주요 로직은 추상화되고, runtime 시에는 DIP 개념을 활용하여 실제 구현체가 동작하게 한다.
  ![image](https://user-images.githubusercontent.com/28394879/144636026-95d7e3a4-ba3f-4fae-b685-bfbdb1368621.png)
  - domain layer에서는 interface에 해당하는 패키지를 import해오면 잘못된 것이다.

### Layer 별 구현 상세
#### 1. Domain Layer
DDD에서 말하는 domain layer의 역할은 다음과 같다.  
- 업무 개념과 업무 상황에 대한 정보, 업무 규칙을 표현하는 일을 책임진다.
- 이 계층에서는 업무 상황을 빤영하는 상태를 제어하고 사용하며 그와 같은 상태 저장과 관련된 기술적인 세부사항은 인프라 스트럭쳐에 위임한다.
- 이 계층이 업무용 소프트웨어의 핵심이다

DDD의 목표는 기술보다는 도메인에 대한 모델에 집중해 더 나은 소프트웨어를 만들어내는 것이다 (DDD 154p 참고)   
DDD 에서 도메인 모델을 정의하고 구현하는 layer는 domain layer이기 떄문에 DDD에서는 domain layer 가 핵심이다.

여기에서의 domain layer의 표준 구현은 다음과 같다.
1. domain layer에서의 Service에서는 해당 도메인의 전체 흐름을 파악할 수 있도록 구현되어야 한다.
    - 이를 위해서는 추상화 레벨을 많이 높혀야 한다.
      - 도메인 로직에서는 어떤 기술을 사용했는지는 중요하지 않다. 어떤 업무를 어떤 순서로 처리했는지가 더욱 중요한 관심사이다.
      - 도메인 업무는 적절한 interface를 사용하여 추상화하고 실제 구현은 다른 layer에 맡기는게 맞다.
    - 세세한 기술 구현은 Service가 아니라 Infrastructure의 implements 클래스에 위임하고, Service에서는 이를 활용하기 위한 interface를 선언하고 사용한다.
      - DIP를 활용하여 도메인이 사용하는 interface의 실제 구현체를 주입 받아(injection) 사용할 수 있도록 한다.
      - 영속화된 객체를 로딩하기 위해 Spinrg JPA를 사용할 수도 있지만 MyBatis를 사용할 수도 있는 것이다. domain layer에서는 객체를 로딩하기 위한 추상화된 interface를 사용하고, 실제 동작은 하위 layer의 기술 구현체에 맡긴다는 것이 핵심이다.
    - 이런식의 구현을 가져가면
      - service의 메서드를 읽기만해도 업무 도메인의 흐름을 대략적으로 파악이 가능하고
      - interface로 추상화된 실제 구현 기술은 언제든지 원하는 것으로 교체 가능하게 된다.
    - (Spring Boot 기반의 구현이라면) 도메인을 대표하는 하나의 Service가 존재하게 하고, 해당 Service에는 @Service를 붙인다.
      - 해당 제안을 규약으로 가져가면, 다른 개발자들이 해당 도메인을 파악할 때 엔트리 포인트가 되는 로직을 빠르게 찾을 수 있을 것이라 기대한다.

2. domain layer에서의 모든 클래스명이 Xxx**Service**로 선언될 필요는 없다. 
   - 하나의 도메인 패키지 내에 수많은 Service 클래스가 존재하게 되면, 도메인 전체의 흐름을 컨트롤하는 Service가 무엇인지 알기 어렵다.
     - 주요 도메인의 흐름을 관리하는 Service는 하나로 유지하고, 이를 위한 support역할을 하는 클래스는 Service이외의 네이밍을 가져가는 것이 좋다.
   - 또한 하나의 책임을 가져가는 각각의 구현체는 그 책임과 역할에 맞는 네이밍으로 선언하는 것이 가독성에 좋다
     - 아래와 같은 네이밍이 적절한 예시가 될 것이다
       - Xxxx**Reader**
       - Xxxx**Store**
       - Xxxx**Executor**
       - Xxxx**Factory**
       - Xxxx**Aggregator**
     - 다만 해당 구현체는 domain layer 에서는 interface로 추상화하고 실제 구현체는 Infrastructure layer에서 구현한다.
     - 즉, domain layer에서는 도메인 로직의 흐름을 표현하고 구현하는 Service 와 ServiceImpl이 있지만 그 외의 상세한 구현은 Reader, Store, Executor 같은 interface를 선언하여 상요하고 이에 대한 실제 구현체는 Infrastructure layer에 두고 활용한다 (DIP)

3. Service간에는 참고 관계를 가지지 않도록 한다.
  - DDD의 Aggregate Root 개념을 알고 있다면 도메인 내의 Entity 간에도 상하 관계까 명확히 생긴다는 것을 알게 된다.
  - 이와 마찬가지로 Service로직을 구현하다보면 좀 더 상위 레벨의 Service와 하위 레벨의 Service가 도출되기 마련인데, 이런 구조를 허용하게 되면 상위 레벨의 Service가 하위 레벨의 Service를 다수 참조하게 되면서 로직이 구성된다.
    - 경험상 시간이 지날수록 특정 Service가 참조하는 하위 Service는 점점 늘어나는 경향이 있다
    - 이는 테스트 코드 작성을 어렵게 하고 가독성도 많이 떨어지게 된다
  - Service간에는 참조 관계를 가지지 않도록 원칙을 세우는 것이 좋다
    - Service내의 로직은 추상화 수준을 높게 가져가고
    - 각 추상화의 실제 구현체는 잘게 쪼개어 만들면
    - 도메인읜 전체 흐름이 파악되면서도 로직이 간결하게 유지되는 코드를 가져갈 수 있다

#### 2. Infrastructure Layer

DDD에서 말하는 Infrastructure layer의 역할은 다음과 같다
- 상위 계층을 지원하는 일반화된 기술적 기능을 제공한다.

여기에서의 Infrastructure layer 표준 구현은 다음과 같다
1. doamin layer에 선언되고 사용되는 추상화된 interface를 실제로 구현하여 runtime시에는 실제 로직이 동작하게 된다
   - DIP 개념을 활용한다. 
   ![image](https://user-images.githubusercontent.com/28394879/144700458-6b40861a-d6e0-4ba3-bfc9-28b6cf1d5b1a.png)
2. 세세한 기술 스택을 활용하여 domain 의 추상화된 interface를 구현하는 것이므로 비교적 구현에서의 자유도를 높게 가져갈 수 있다 
   - 읽어 보면 좋을만한 아티클을 공유한다.
     -  https://deviq.com/principles/persistence-ignorance
     -  https://enterprisecraftsmanship.com/posts/having-the-domain-model-separate-from-the-persistence-model/
3. Service간의 참조 관계는 막았지만, Infrastructure layer 에서의 구현체 간에는 참조 관계를 허용한다.
   - Infrastructure에서의 구현체는 domain layer에 선언된 interface를 구현하는 경우가 대부분이므로 Service에 비해 의존성을 많이 가지지 않게 된다
   - 로직의 재활용을 위해 Infrastructure내의 구현체를 의존 관계로 활용해도 된다
   - 다만 이 과정에서도 순환 참조가 발생하지 않도록 적절한 상하관계를 정의하는 것이 좋다(필요시 정의)
4. (Spring Boot 기반의 구현이라면) @Component를 활용한다
   - Spring 내의 동일한 bean이라도 @Service와 @Component를 구분하여 선언하여 명시적인 의미를 부여하고자 한다
   - 이 내용은 여기에서의 권장 표준 정도로 한다
     - Spring 에서 @Service와 @Component는 동일하게 class를 bean으로 등록하고 큰 차이는 없다
     - 다만 annotation 을 통해 해당 class의 의미를 부여하고 싶었다.

#### 3. Application Layer
도메인 주도 설계 (이하 DDD) 에서 말하는 application layer의 역할은 다음과 같다
- 수행할 작업을 정의한다
- 도메인 객체가 문제를 해결하도록 지시한다
- 다른 애플리케이션 계층과의 상호 작용을 한다
- 비즈니스 규칙은 포함하지 않으며, 작업을 조정하고, 다음 하위 계층에서 도메인 객체의 협력을 위해 업무를 위임한다
- 그렇기 때문에 해당 Layer는 얇게 유지된다
- 작업을 조정하기만 하고 도메인 상태를 가지면 안 된다

여기에서 가질 수 있는 의문이 있다면 다음과 같다
- 수행할 작업을 정의하고 작업을 조정하는게 결국 도메인 로직 아닌가?
- 다른 애플리케이션 계층과 상호작용을 하게되면 어쩔 수 없이 import와 생성자 인자가 많아질 수 밖에 없는 것 아닌가?

여기에서의 application layer 표준 구현은 다음과 같다.
1. application layer에서는 
   - transaction으로 묶여야 하는 도메인 로직과
   - 그 외의 로직을 aggregation하는 역할로 한정 짓는다.
   - 그러므로 해당 로직이 두꺼워질 요소는 없다
2. 해당 layer의 클래스 네이밍은 Xxx**Facade**로 정한다
   - Facade의 개념은 복잡한 여러 개의 API를 하나의 인터페이스로 aggregation하는 역할이지만
   - 우리가 정의하는 application layer내의 Facade는 서비스 간의 조합으로 하나의 요구사항을 처리하는 클래스로 정의하였다.
3. 실제적인 요구사항을 예시로 하여 Facade 구현을 정의해보면 다음과 같다
   - "주문완료 후 유저에게 카카오톡으로 주문 성공 알림이 전달된다"라는 요구사항이 있다고 해보자
     - 주문 처리 과정에서의 모든 도메인 로직은 하나의 transaction으로 묶여야 정합성에 이슈가 없다.
     - 그러나 주문 완료 직후의 카카오톡 알림 발송이 실패하더라도, 주문 로직이 전체 롤백될 필요는 없다
       - 카카오톡 알림 발송이 실패했더라도 유저는 메인 서비스를 통해서 주문 완료를 확인할 수 있기 떄문에
   - 이런 맥락을 기반으로 Facade내에 **주문 완료** 메서드를 구현하면 다음과 같다
        ![image](https://user-images.githubusercontent.com/28394879/144700903-fc2a3663-4bd0-4d90-a62c-f59ffcb3c9c0.png)
        - Facade안의 completeOrder 메서드에는 transaction을 선언하지 않는다.
        - orderService.completeOrder(registerOrder) 내에는 transaction이 선언되어 있고, 주문완료 처리 중에 예외가 발생하면 Order Aggregate전체 데이터가 rollback이 된다 (정합성이 지켜지는것)
        - orderService.completeOrder(registerOrder)가 성공하고 notificationService.sendKakao()가 실패하더라도, 주문 완료 처리는 rollback 되지 않는다.
        - Order Aggregate의 정합성은 지키면서도, 주요 도메인 로직에는 포함되지 않는 외부 서비스 call (여기서는 카카오톡 알림 발송)은 성공/실패에 크게 민감하지 않게 요구사항을 처리하게 된다 

한줄요약
- 외부와 커뮤니케이션 하면서 도메인 로직을 요구사항에 맞게 실행하는 역할이 어플리케이션 layer의 역할이다. 
- 도메인쪽과 도메인외의 기능적인 요소를 조합해서 유저쪽의 하나의 요구사항을 처리하는 layer이다. 


#### 4. Interfaces Layer
DDD에서 말하는 Interfaces layer의 역할은 다음과 같다
- 사용자에게 정보를 보여주고 사용자의 명령을 해석하는 책임을 진다.

여기에서의 Interfaces layer 표준 구현은 다음과 같다.
1. API를 설계할 때에는 없어도 되는 Request Parameter는 제거하고, 외부에 리턴하는 Response도 최소한을 유지하도록 노력하자.
   - 요구하는 Request Parameter가 많다는 것은 관련된 메서드나 객체에서 처리해야 하는 로직이 많다는 것을 의미하고, 이는 관련된 객체가 생각보다 많은 역할을 하고 있다는 신호일 수 있다
   - Response의 경우도 불필요한 응답을 제공하고 있고 이를 가져다 쓰는 외부 로직이 있다면, 추후 해당 Response 에서 특정 프로퍼티는 제거하기 어렵게 될 수 있다.
   - API는 한번 회부에 오픈하면 바꿀 수 없는 것이라고 생각하자. 처음부터 제한적으로 설계하고 구현해야 한다.
2. http, gRPC, 비동기 메시징과 같은 서비스간 통신 기술은 Interfaces layer에서만 사용되도록 하자
   - 가령 json 처리 관련 로직이나 http cookie 파싱 로직 등이 Domain layer에서 사용되는 식의 구현은 피해야 한다
   - 그렇게 하지 않으면 언제든지 교체될 수 있는 외부 통신 기술로 인해 domain 로직까지 변경되어야 하는 상황이 발생한다.
 
![image](https://user-images.githubusercontent.com/28394879/144701499-6980eedb-e95a-4c1e-bfdb-b1a8d2b33c97.png)

</details>

<details><summary> 2. 권장하는 구현 방식 </summary>

## 2. 권장하는 구현 방식

### 개발 디자인 문서를 작성한 후에 구현을 시작하자
- 개발을 시작하기 전에 **개발 디자인 문서**를 작성하고 동료와 함께 공유하는 것을 권한다.
- 서비스 구현에 대한 목표와 설계, 제약 사항 등을 미리 생각해본 후에 개발을 시작한다면 큰 시행 착오 없이 원하는 구현을 진행할 수 있다
- **개발 디자인 문서**를 작성한 후에 이를 동료들과 리뷰하는 과정을 거친다면 좀 더 좋은 디자인과 방향성을 잡을 수 있다
- 서비스의 인수인꼐 과정에서도 코드와 함께 **개발 디자인 문서**를 전달한다면, 넘겨 받는 동료가 해당 서비스에 대한 구조 파악을 비교적 빠르게 진행할 수 있다


### 개발 디자인 문서 양식의 일부 예시
1. 문제 정의
   - 배경 (현재 어떠한 상황이고 개발로써 어떻게 해결할 것인가?)
   - 필수 조건 (개발한 시스템의 성공 조건이 무엇인가?)
   - 목표
   - 목표가 아닌 것
   - 평가 (이 시스템의 성공과 실패를 어떻게 평가할 것인가?)
2. 해결 방안
   - 설계 (다이어그램은 필수로 그려야 함)
   - 구현 (Tech Stack)
   - 테스트
   - 코드리뷰
   - 모니터링
   - 보안
3. 배포 계획
   - 계획 (어떤 유저에게, 어떤 feature 를, 단계적으로)
   - 배포 (어떻게 배포할 것인가?)
4. 타임라인
   - 로드맵 (단계별 마일스톤)

### 테이블 설계를 먼저하지 말고 핵심 도메인 도출을 먼저하자
- 테이블은 도메인 객체를 영속화하기 위한 그릇 정도의 역할로 생각하는 것이 좋다.
    - ORM이 생기면서 테이블 중심으로 코드를 구현하던 패러다임이 진정한 객체 중심의 개발로 전환될 수 있었다
- 코딩을 하기 전에 먼저 해야할 것은
    - 우리가 개발해야 하는 주요 요구사항과 제약 등을 검안하면서
    - 핵심 도메인 객체를 도출하고
    - 특정 기능을 수행하기 위해 도메인 간에 주고 받아야 하는 메시지를 먼저 정의하는 것이다

### 변수명, 메서드명에 많은 신경을 쓰자
- 변수명이나 메서드명을 읽었을 때, 그것이 무엇을 의미하는지 빠르게 이해할 수 있도록 네이밍을 하는 것이 좋다
- DDD 에서 말하는 유비쿼터스 언어 (Ubiquitous) 개념처럼 - 현업에서 사용하는 보편적인 언어를 최대한 반영하자
- 전사 표준, 또는 프로젝트 내에서의 네이밍 규칙을 세우고 운영하는 것도 좋다
    - 슬랙에서 별도의 채널을 만들어 코드 네이밍을 위한 의견을 주고 받는 장치를 마련하는 것도 좋다

### API의 명세에서 request와 response의 프로퍼티는 필수값만 유지되도록 한다.
- API를 설계할 때에는 없어도 되는 request는 제거하고, 외부에 리턴하는 response도 최소한을 유지하도록 노력하자
- 요구하는 request가 많다는 것은 해당 메서드나 객체에서 처리해야 하는 로직이 많다는 것을 의미한다
    - 이는 해당 객체가 생각보다 많은 역할을 하고 있다는 신호일 수 있다
- response의 경우도 API 목적에 맞지 않는 불필요한 응답을 포함하여 제공하고 있고, 이를 가져다 쓰는 외부 로직이 있다면
    - 추후 해당 response 에서 특정 프로퍼티는 제거하기 어렵게 될 수 있다
- 아래의 메서드를 예시로 보자
    - boolean isAgreement 로 내부 로직에서 if 구문이 존재할 것으로 예상할 수 있다
        - 이는 두가지의 일을 하는 메서드라고 유추할 수 있다 ( 안 좋은 예 )
        ```java
        // isAgreement 가 true 이면 동의처리, false 이면 거부 처리
        public void processReceiveAgreement(String userId, boolean isAgreement) {
        }
        ```
        - 로직의 분리 ( 위의 processReceiveAgreement 보다는 아래 처럼 분리하는 것이 좋다 )
        ```java
        public void receiveAgreement(String userId) {
        }
        public void receiveDisAgreement(String userId) {
        }
        ```

### setter는 쓰지 않거나 최소화한다
- setter는 캡슐화된 도메인과 객체를 깨뜨리는 주범이 된다
- 도메인 객체를 생성할 때에는 생성자를 활용하여 필수값을 객체 생성 시에 받도록 하고, 도메인의 상태를 변경할 때에는 적절한 메서드명을 가지는 상태 변경 로직을 구현하는 것이 맞다
- 그렇게 할 경우 도메인을 변경할 때에는 해당 도메인이 제공하는 상태 변경 로직을 호출할 수 밖에 없고, 이는 도메인 내의 정합성을 유지하는데 도움이 된다
- 아래의 메서드를 예시로 보자
    - 아래와 같은 setter가 존재하면, 이를 사용하는 측에서는 도메인 객체의 상태를 묻고 상태를 변경하는 로직이 필연적으로 생기게 된다 (안 좋은 예)
    ```java
    public void setStatus(Status status) {
        this.status = status
    }
    ```
    - getter, setter 사용 로직 - 도메인의 상세 정보를 묻고 상태를 변경하는 로직이 생기는 상황 (안 좋은 예)
    ```java
    if (order.getStatus() == Order.Status.INIT) {
        order.setStatus(Order.Status.ORDER_COMPLETE);
    }
    ```
    - 아래와 같이 의밀르 부여한 변경 로직이 유지보수와 도메인 정합성에 도움이 된다 (좋은 예)
    ```java
    public void deposited() {
        if(this.status == Status.CREATED) {
            this.status = Status.DEPOSITED;
        }
    }
    ```
    - DEPOSITED 라는 상태로 변경을 시도하되, CREATED 상태일때만 가능하다는 일종의 도메인 로직을 표현하고 있다
    - CREATED 상태가 아니면 DEPOSITED로 변경 될 수 없기 떄문에 해당 도메인의 정합성도 유지될 수 있다

### transaction의 사용과 범위 설정은 여러 번 고민 후 결정하자
- transaction은 도메인의 데이터의 정합성을 위한 필수 기능이다
- 다만 서비스 성격에 따라 transaction 의 범위를 적절히 잡는 것이 중요하다
- transaction 의 범위는 당연히 작게 잡는 것이 좋다
- 또한 transaction 내에서 외부 3rd party 서비스를 호출하는 로직이 있다면 적절한 타임아웃 설정은 필수이고, 필요에 따라서는 transaction 내에 포함시키지 않는 것도 고려해야 한다
    ```
    @Transactional
    public void 주문완료() {
        1. 주문 정보 로딩 (order)
        2. 결제 처리 (payProcessor.pay(order))
        3. 주문 완료 (order.orderComplete)
    }
    ```
    - 2번 결제 처리가 성공하면 아무 상관 없지만, 실패 일경우엔 문제가 생길 수 있다.
    - 예를 들면 실패에 대해서 응답이 늦게 나오고,  timeout설정이 무한대로 되어있는 경우엔 전체 시스템에 문제가 생길 수 있다.
    - 그래서 이왕이면 결제처리는 마지막 처리로 빼거나, transactional에서 빼서 transactional의 범위를 작게 잡는게 좋다.
    ```
    public void 주문완료() {
        1. 주문 정보 로딩 -> transactional O
        2. 결제 처리 -> transactional X
        3. 후처리 로직 -> transactional O
    }
    ```

### 도메인 객체가 무조건 DB 에 저장되는 것은 아니다
- 모든 도메인 객체가 Repository를 통해 저장되고 관리되는 것은 아니다
- 테이블이 저장되지 않는 도메인 객체도 얼마든지 존재할 수 있다
```java
@Getter
@ToString
@EqualsAndHashCode
public class Money implements Comparable<Money> {
    private final BigDecimal value;
    public static final Money ZERO = Money.of(BigDecimal.ZERO);
    private Money(BigDecimal value) {
        this.value = value.setScale(0, RoundingMode.HALF_EVEN);
    }
}
```
    - Money는 결제 서비스 전반에 사용되는 필수 파라미터이면서 도메인 객체이지만, DB에 저장되는 도메인 객체는 아니다
    - 결제 서비스에서 가격 계산과 정합성 체크는 중요한 도메인 로직이고, 그렇기 때문에 Money 라는 객체 안에 해당 로직을 모아 놓았다.
    - 참고 - DDD 에서 식별자를 가지지 않는 도메인 객체를 Value Object 라고 하고, Money 클래스도 Value Object로 볼 수 있다.

### try-catch 는 필요한 경우가 아니라면 쓰지 말자
- 불필요한 try-catch 는 로직 흐름을 파악하기 어렵게 하면서도 코드의 양만 늘리는 주범이 된다
- try-catch의 사용은 Exception을 catch 했을 때 추가적인 로직 구현이 필요한 경우에만 선언하도록 하자
- 그 외에는 필요한 Exception을 그대로 throw 하는 것이 구현도 깔끔하고 로직 흐름에도 좋다
- 아래 코드에서의 try-catch는 불필요한 선언이다
    ```java
    @Override
    @Transactional
    public String registerOrder(OrderCommand.RegisterOrder requestOrder) {
        try {
            Order order = orderStore.store(requestOrder.toEntity());
            orderItemOptionSeriesFactory.createWith(requestOrder.getOrderItemList(), order);
            return order.getOrderToken();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    ```
    - catch 구문으로 Exception을 잡았지만 Exception을 RuntimeException 으로 wrapping 하는 것 말고는 하는 것이 없다
    - 이런 경우 Exception 이 그대로 throw 되도록 하고 try-catch는 쓰지 않는 것이 좋다
- 아래 코드는 try-catch 선언이 필요한 케이스이다
    ```java
    try {
        var orderItemCommand : OrderItemManagePGCommand.Order
        orderItemManagePGService.increaseItem(orderItemCommand);
    } catch (Exception e) {
        orderItemManagePGService.cancelOrderItemManage(orderId);
    }
    ```
    - try 구문에서는 increaseItem 이 실행되고 그 과정에서 Exception 이 발생하면 cancelOrderItemManage이 실행되는 구조이다
    - 즉, 로직의 실행 과정에서 Exception 이 발생했을 때 의미 있는 비즈니스 로직의 실행이 필요한 경우이므로 이 때에는 명시적으로 try-catch 를 사용해야 한다
    - 물론 catch 구간에서도 별도의 Exception을 throw할 수 있다. 해당 단락의 중심 내용은 의미 없이 try-catch를 쓰지 말자는 내용이다.

### 꼭 필요한 상태 (Status) 만 선언하자
- 도메인 객체의 상태값은 도메인의 Identity 만큼 중요한 프로퍼티다. 상태값을 통해 도메인의 객체의 상태를 판별할 수 있고, 그에 따라서 적절한 로직 실행이 가능하기 때문이다
- 다만, 너무 세분화된 상태값 구분은 해당 도메인을 이해하기 어렵게 만들고 코드 구현에서도 고려할 것이 많아진다.

### 주요 로직의 테스트 코드는 본인을 살리는 길이다
- 요구사항은 수시로 변경된다. 이 때 개발자가 가장 두려워하는 것은 특정 기능을 추가하거나 변경했을 때 예상하지 못한 버그가 발생하지 않을까 하는 막연한 두려움이다
- 이를 막을 수 있는 가장 좋은 방법은 주요 로직에 대한 테스트 코드 작성과 코드 리뷰이다.
- 개발 과정 중에도 수시로 요구사항이 변경되고 추가되는데, 그 때마다 테스트 코드를 돌려가면서 피드백을 받는다면 버그를 찾기 쉽고 기능 구현도 빠르게 진행할 수 있다


### 우선 목표한 기능이 동작하게끔 구현한 후에 작게 리펙토링 하자
- 깔끔한데 동작 안하는 코드보다는 더럽지만 동작하는 코드가 백번 낫다
- 처음부터 깔끔하게 짜려고 노력하지 말고, 우선 기능이 되게끔 구현한 후에 일정 시점마다 리펙토링을 시도하는 것이 좋다
    - 물론 처음부터 깔끔하고 빠르고 기능에 맞게 구현할 수도 있다
- 구현을 하다보면 처음에 생각하지 못했던 여러 요소를 발견하게 되고, 도메인 지식도 더 깊어지게 된다
    - 그렇게 되면 구현 전의 과거 시점과는 다른 시각으로 코드 구현을 생각하게 되는데, 그런 시간차를 짧게 줄이려면 우선은 동작하는 코드를 빠르게 만드는 것이 좋다
- 코드 구현과 비즈니스는 둘다 속도가 중요하다는 점을 명심하자

### 무조건 정석대로 구현할 필요는 없다
- 약속한 시점에 기능을 런칭하는 것은 정말 중요하다
    - 물론 여러가지 변수가 발생할 수 있으니 지속적으로 팀 동료와 대화하고 맞춰가면서 개발 스펙과 일정을 조정할 수 있다
- 이런 상황을 맞추기 위해 중복 코드와 하드 코딩이 필요하다면 그렇게 구현해도 된다
    - 다만 이런 구현은 한시적으로만 운영되고 문제 상황이 종료되었담녀 정리해야 함을 전제로 한다
- 모든 것은 균형이 중요하다
    - 비즈니스의 가치를 만들어 내기 위한 하드코딩도 필요하고
    - 비즈니스 가치를 지속적으로 제공하기 위해 코드와 프로젝트 구조를 깔끔하게 유지하는 것도 중요하다

</details>

<details><summary> 3. 실습 개발 환경 세팅 </summary>

## 3. 실습 개발 환경 세팅

### 실습 환경 
- Java 11
  - AdoptOpenJDK 를 설치한다.
  - https://adoptopenjdk.net/
- Docker
  - 원활한 개발과 구현을 위해 로컬에 Docker를 설치하고 MySQL 인스턴스를 띄울 예정이다.
  - 이를 위해 Docker를 설치한다.
  - MacOS: https://docs.docker.com/desktop/mac/install/
  - Window: https://docs.docker.com/desktop/windows/install/
- IntelliJ
  - https://www.jetbrains.com/ko-kr/idea/download/
- DataGrip
  - 데이터베이스 관리 Tool이다.
  - https://www.jetbrains.com/ko-kr/datagrip/download/#section=mac

### 프로젝트 다운로드 & 초기 셋팅
- github에서 프로젝트 다운로드
  - example-order:  https://github.com/gregshiny/example-order
  - example-gift: https://github.com/gregshiny/example-gift
- 로컬 환경에서 docker-compose 실행
  - spring boot 기반으로 초기 개발을 진행할 때에는 memory기반의 h2db를 사용하면 수시로 변경되는 Entity 스펙에 관계없이 빠른 개발이 가능하지만, 여기에서는 설계와 요구사항을 모두 정의한 상태에서 개발을 진행하기 떄문에 로컬에 MySQL을 설치하고 개발을 진행한다.
  - 각 프로젝트 root 밑에 /docker-compose 라는 디렉토리를 만들어놨다.
  - terminal에서 해당 디렉토리에 위치한 다음 아래 명령어를 실행하면 docker내에서 MySQL이 설치된다.
    - example-order: **docker-compose -p order-db up -d**
    - example-gift: **docker-compose -p gift-db up -d**
- docker내의 MySQL을 멈추려면 아래 명령어를 실행한다.
  - docker-compose down 또는
  - docker-compose down --volume


</details>

# 3. 주문 프로젝트 개발

<details><summary> 1. 주문 프로젝트 개발 </summary>

## 1. 주문 프로젝트 개발
일상 생활에서 흔히 접할 수 있는 e-commerce 서비스의 주문 도메인을 예시로 하여 실제적인 프로젝트를 구현하고자 한다.

**해당 서비스의 주요 이해관계자는 다음과 같다**  
1. 유저 - 서비스를 통해 상품을 선택하여 주문하는 고객
2. 파트너 - 해당 서비스에 입점하여 상품을 판매하는 업체
3. 내부 운영자 - 해당 서비스를 운영하고 관리하는 담당자

**해당 서비스의 주요 도메인은 다음과 같다**  
1. 파트너 - 파트너 등록과 운영을 처리함
2. 상품 - 상품과 상품의 옵션 정보를 등록하고 관리함
3. 주문 - 유저가 선택한 상품 정보와 주문 정보를 관리하고 결제를 처리함

**각 도메인별 주요 요구사항은 다음과 같다**  
1. 파트너
   - 시스템에 등록된 파트너만이 상품을 등록하고 주문을 처리할 수 있다
   - 파트너 등록 시 파트너명, 사업자등록번호, 이메일은 필수값이다.
   - 파트너는 계약이 종료되면 비활성 상태로 전환된다. 단, 파트너 정보 자체는 삭제되지 않고 유지된다
   - 파트너 등록이 성공하면 등록된 이메일로 가입 완료 안내 메일을 발송한다
   - 그 외 시스템을 사용하는 유저가 기본적으로 기대하는 기본 기능들 - 조회, 등록, 수정, 삭제 등의 기능을 제공해야 한다
2. 상품
   - 시스템에 등록되고 활성화된 파트너는 상품을 등록할 수 있다
   - 등록된 상품은 유저의 주문을 받아 판매될 수 있다
   - 상품은 상품명, 가격 등의 기본 정보와 색상, 사이즈와 같은 옵션으로 구성된다
   - 상품은 옵션 정보 없이 기본값으로만 저장될 수도 있다
   - 주문 화면에서 보여지는 상품의 옵션은 파트너사가 원하는 순서에 맞게 노출될 수 있어야 한다
   - 상품 구매 시 특정한 옵션을 선택하면 가격이 추가 될 수 있다
   - 상품은 판매 준비중, 판매중, 판매 종료와 같은 상태를 가진다
   - 그 외 시스템을 사용하는 유저가 기본적으로 기대하는 기본 기능들 - 조회, 등록, 수정, 삭제 등의 기능을 제공해야 한다
   - **여기에서는 실제의 복잡한 상품 도메인 요구사항을 간소화 하였습니다(수량 등의 속성 생략)**
3. 주문
   - 시스템에 등록된 상품은 유저가 주문할 수 있다
   - 주문은 주문 등록, 결제, 배송준비, 배송중, 배송 완료의 단계를 가진다
   - 주문 등록 과정에서는 결제수단을 선택하고 상품 및 상품 옵션을 선택한다
   - 시스템에서 사용 가능한 결제 수단은 1) 카드 2) 토스페이 3) 카카오페이 4) 네이버페이 등이 있다
   - 결제 과정에서는 유저가 선택한 결제수단으로 결제를 진행한다
   - 결제완료 후 유저에게 카카오톡으로 주문 성공 알림이 전달된다
   - 결제가 완료되면 배송준비 단계로 넘어간다
   - 배송중, 배송완료의 단계도 순차적으로 진행된다
   - **여기에서는 실제의 복잡한 주문 도메인 요구사항을 간소화 하였습니다(결제 연동, 취소 등의 요구사항 생략)**

주요 도메인별 다이어그램은 아래와 같다 
![image](https://user-images.githubusercontent.com/28394879/144715257-02427d8a-6f21-4575-ac58-0d79a7262591.png)



</details>

<details><summary> 2. Partner Domain 개발 </summary>

## 2. Partner Domain 개발

### 2-1. Entity, Service 개요 

#### 요구사항
- 시스템에 등록된 파트너만이 상품을 등록하고 주문을 처리할 수 있다
- 파트너 등록 시 파트너명, 사업자 등록번호, 이메일은 필수값이다
- 파트너는 계약이 종료되면 비활성 상태로 전환된다. 단, 파트너 정보 자체는 삭제되지 않고 유지된다
- 파트너 등록이 성공하면 등록된 이메일로 가입 완료 안내 메일을 발송한다
- 그 외 시스템을 사용하는 유저가 기본적으로 기대하는 기본 기능들 - 조회, 등록, 수정, 삭제 등의 기능을 제공해야 한다 

#### 도메인 계층 설계 및 구현 (domain package)
##### Entity 구현
- 파트너라는 도메인의 용어를 정의한다
  - Partner
- 객체 관점에서 필수 속성과 메서드를 정의한다
  - 필수 속성
    - partnerName
    - businessNo
    - email
  - 필수 메서드
    - 파트너 상태 활성화
    - 파트너 상태 비활성화
- 요구사항에는 없지만 시스템의 안정적인 운영을 위해 추가적인 속성을 정의한다
  - Entity와 PK와 동등하게 사용되는 대체키를 선언한다
    - partnerToken
  - 추후 시스템 외부에 파트너 API를 오픈하여 기능을 제공할 떄에는 partner의 식별자가 아니라 대체키를 사용하도록 한다
  - 하단의 **대체키에 대하여** 단락 참고
- AbstractEntity를 확장하여 사용한다
  - 데이터의 생성과 변경에 대한 정확한 일시를 남기는 것은 정말 중요하다
    - 데이터 처리와 운영, CS 대응
    - 데이터 기반의 의사 결정을 위한 지표 추출
  - Entity를 통한 데이터의 등록과 변경 과정에서 해당 일시를 남기는 반복적인 코딩을 막기 위해 JPA에서 제공하는 Auditing을 활용한다
  ![image](https://user-images.githubusercontent.com/28394879/144730003-3601df7e-102f-4ddd-b857-6d740c6e9bb5.png)
    - @MappedSuperclass는 JPA Entity 클래스에서 공통 매핑 정보가 필요할 때, 부모 클래스에 속성을 선언하고 상속하여 사용이 가능하게 해주는 annotation이다
      - 주문 프로젝트의 Entity 전체가 AbstractEntity를 상속하면, 데이터의 등록과 변경 시점을 표현하는 속성을 그대로 상속할 수 있다
    - @EntityListeners는 이름 그대로 JPA Entity에 특정 이벤트가 발생했을 때의 리스너와 실행 이벤트를 표현하는 annotation이다
      - 여기서는 Spring JPA가 제공하는 AuditingEntityListener를 연결하여 데이터 등록과 변경 시점을 기록하게 한다
    - @CreationTimestamp와 @UpdateTimestamp는 데이터 등록과 변경 시험을 기록하는 컬럼의 선언이다
      - 주문 프로젝트의 모든 시간과 관련 컬럼은 LocalDateTime이 아니라 ZoneDateTime을 사용하기 떄문에 ZonedDateTime을 지원하는 @CreationTimestamp와 @UpdateTimestamp를 사용한다
      - Spring이 제공하는 @CreatedDate와 @LastModifiedDate는 ZonedDateTime을 지원하지 않는다
    - JPA Auditing을 활성화하기 위해서 아래와 같이 @EnableJpaAuditing을 추가한다
    ```java
    @EnableJpaAuditing
    @Configuration
    public class JpaAuditingConfiguration {

    }
    ```

##### Service 및 Implements 구현 
- 여기에서 제안할 도메인 로직과 Service의 역할은 다음과 같다
  - 코드를 읽으면 해당 도메인의 전체 흐름을 파악할 수 있어야 한다
  - 세세한 구현은 low level 기술은 implements (infrastructure)에 위임하고, 위임을 맡기는 구간을 interface로 정의하여 사용한다
  - Service간에는 참조 관곌르 두지 않는다
  - 하단의 **의존성 역전 원칙(DIP)** 단락 참고
- PartnerService <Interface> 에서 제공해야 하는 요구사항을 정의한다
  - 파트너 등록
  - 파트너 정보 조회
  - 파트너 활성화
  - 파트너 비활성화
- PartnerService를 정의하는 과정에서 Command 와 Criteria, Info 객체의 의미를 설명하고 활용한다
  - Command와 Criteria는 Service메서드의 처리와 조회를 위한 파라미터이다
    - Command: CUD
    - Criteria: R
  - Info는 리턴 객체이다. Database에서 조회하여 가져온 Entity를 그대로 리턴하지 않기 위한 객체이다
    - 도메인 로직의 리턴값으로 Entity를 그대로 리턴하지 않는다
      - 도메인 로직과 Entity는 프로젝트 전반에 걸쳐 사용한다. Layer간의 참조 관계를 생각해보면 명확하다
      - 도메인 로직의 리턴 값으로 Entity를 그대로 전달한다면, domain layer바깥에서 Entity내의 도메인 로직이 호출되거나 Entity의 속성을 변경하는 명령어가 실행될 수 있다
      - 이는 도메인 로직을 domain layer에 응집하고자 하는 의도에 맞지 않고, 경우에 따라서는 Entity하위 객체의 로딩 과정에서 lazy initialization exception 등이 발생할 수도 있다
    - Info 객체는 필요에 따라 Entity 의 일부 속성을 가공할 수 있다
- 구현 과정에서 네이밍에 대한 관례를 정한다
  - getXxxx: 해당 파라미터로 Entity또는 Projection 리턴. 해당 파라미터로 조회 결과가 없다면 Exception 발생
  - findByXxxx: Optional<T> 리턴
  - makeXxxx: DB Operation 과 관계 없이 메모리 상에서 값을 조합하여 객체를 생성
  - initEntity: makeXxxx 로 생성된 초기 Entity. DB에 저장된 객체가 아니므로 Auto Increment 기반의 PK 값이 null 임
- 파트너 Entity가 제공하는 기능과 세부적인 기술을 제공하는 implements와의 조합으로 PartnerService의 구현체를 만든다
  - Partner 도메인의 조회와 저장을 담당하는 interface 를 각각 선언한다
    - PartnerReader
    - PartnerStore
  - 이제 Spring JPA를 사용하여 PartnerReader 와 PartnerStore의 구현체를 만들고, 이를 infrastructure layer에 둔다
    - 도메인 로직이 low level 기술에 영향을 받지 않도록 DIP 개념을 적용한다 **(클린 소프트웨어 166P 참고)**
    - Spring JPA를 활용하여 Persistence Layer를 구현하겠지만 추후 다른 Data Access Layer 구현 기술을 사용할 수도 있다
- 이후 리펙토링을 통해 Service 로직 자체의 가독성을 높인다
  - 지속적으로 Service의 추상화 레벨을 확인한다 - 도메인 로직의 가독성을 유지하고 너무 세세한 구현이 반영되지 않도록 한다
  - 모든 비즈니스 로직의 접미사를 XxxService로 정할 필요는 없다
    - Reader, Store, Aggregator, Executor등의 접미사를 통해 좀 더 해당 객체의 책임과 역할을 상세히 정의할 수 있다
  - Service간에는 참조 관계를 가지지 않게 하고, 도메인의 요구사항을 한 눈에 파악 할 수 있는 지속적으로 리펙토링 해나간다
    - 이렇게 하지 않으면 Service 클래스 자체가 뚱뚱해지는 경향이 있다. 도메인 흐름을 파악하기 어렵고 테스트도 어렵다
    - 기능이 추가될 때마다 생성자의 인자나 import가 과도하게 늘어나지 않도록 주의한다
- 그 외 항목의 리펙토링을 진행한다
  - PartnerInfo.of(partner)
- @Transactional을 붙인다
  - Service에서 정의하고 구현한 메서드는 요구하항 하나 하나를 반영한다. 이 때, 데이터 정합성을 생각하면 하나의 transaction으로 묶여서 처리되어야 하는 경우가 대부분이다
    - Service에서는 Domain의 Aggregate Root와 연관된 객체를 모두 가져오고 low level 기술을 활용하여 데이터를 조회하고 저장한다
    - 이 때, 데이터 처리 및 외부 API 호출의 성공 / 실패 여부에 따라서 처리한 데이터를 전체 commit 또는 rollback을 해야할 수도 있다
    - 가령, 부모 객체는 데이터베이스 저장에 실패하고 자식 객체만 저장에 성공하면 데이터 정합성 측면에서 이슈가 된다
    - 데이터 정합성을 위해 의미있는 작업 단위마다 @Transactional 을 붙여야 한다
  - readonly의 경우 성능 최적화 측면에서 선언하는 것이 좋다
    - https://vladmihalcea.com/spring-read-only-transaction-hibernate-optimization/ 참고



### 2-2. 대체키와 DIP

#### 대체키에 대하여 

##### 식별자, PK
- DDD의 Entity개념에서 고유한 식별자는 중요한 개념이다
- Entity는 자신의 생명주기동안 형태와 내용이 급격하게 바뀔 수도 있지만 연속성은 유지해야 한다 **(도메인 주도 설계 93p 참고)**
- 이렇게 변화하는 Entity를 추적하려면 식별성이 부여되어야 하고, 식별자는 해당 시스템 내에서 유일하고 변경되어서는 안 된다
- 보통 DBMS로 영속성을 관리하는 시스템에서의 Entity 식별자는 Table의 PK와 매핑되는 경우가 대부분이다
- MySQL의 경우 주로 AUTO_INCREMENT bigint 속성을 활용한다 

##### 대체키의 정의, 필요성
- 원래 대체키라는 용어 (Surrogate Key)는 자연키라는 용어와 대칭하는 개념인데, 여기에서는 Entity의 식별자와 동급의 의미를 가지는 추가 식별자 정도로 용어를 정의하고자 한다
- Entity의 식별자는 외부에 오픈하거나 오용되지 않도록 주의하고, 식별자가 아닌 대체키를 오픈하는 것이 여러모로 좋다
- Entity 식별자를 외부에 직접 오픈했을 때의 이슈 상황을 예시로 설명하면서, 대체키 사용의 필요성을 대신하고자 한다
- 예시 1 - 2020년 5월 특정 서비스의 실제 사례
  - BigInt(Long) 형태의 유저 아이디를 URL PATH로 사용하여 유저의 거래내역을 노출하는 GET API가 있다고 하자
  - 이런 경우, (인증 과정이 없다는 전제하에) URL의 숫자만 조작하면 다른 이의 거래 내역을 손쉽게 볼 수 있게 된다
  - 이슈 발생 후 랜덤 스트링 형태의 대체키로 변환하여 API를 수정함
- 예시 2 - 외부 연동 서비스
  - 외부 협력사와 자사 서비스 간에 상품 데이터 연동 과정에서 키 값을 시스템 내부의 PK로 사용했다고 가정하자
  - 그렇게 되면 양사간의 데이터는 자사 시스템 내부의 PK로 강하게 묶이게 된다
  - 이 후 자사 시스템에서 데이터베이스를 MySQL 에서 MongoDB 등으로 변경하게 된다면, 달라진 PK 체계로 인해 많은 공수가 발생할 수 있다. 외부 협력사와 추가적인 식별자 논의도 진행해야 한다

##### 구현
- 시스템 내부에서의 Entity 식별자는 Long 타입의 id를 사용하고, 외부에 오픈하여 사용할 때에는 대체키를 사용한다
- 대체키는 String 기반의 token을 생성하고 unique index로 설정하여 사용한다
- 대체키를 사용할 떄에는 역시 성능에 대한 고민이 많을 것인데 MySQL 기준으로 1천만건 이상으로 넘어가기 전까지는 random string으로 사용해도 조회 성능에 크게 이슈가 없고, 성능을 고려한다면 UUID를 rearranged 하여(UUID의 시간값을 맨앞으로 배치함으로써 성능 최적화) 사용하는 것을 검토할 수 있다.
  - https://www.percona.com/blog/2014/12/19/store-uuid-optimized-way/ 참고
   ![image](https://user-images.githubusercontent.com/28394879/144731057-b18984b8-2387-4410-90ed-92ffd9d84288.png)

#### 의존성 역전 원칙 (DIP)
- DIP를 간략히 정의하면 추상화 레벨이 높은 상위 수준의 모듈이 추상화 레벨이 낮은 하위 모듈에 의존하면 안된다는 것이다
- 도메인의 정책이나 업무 모델을 포함하는 것을 상위 수준의 모듈이라고 볼 수 있고, 이를 구현하기 위한 구체적인 세부 기술을 하위 모듈이라고 볼 수 있다
- 상위 수준의 모듈이 하위 수준의 모듈에 의존하는 전통적인 소프트웨어 개발 방식과 달리, 추상화된 상위 모듈에 하위 모듈이 의존하게 만드는 것이 의존성 역전 원칙(Dependency Inversion Principle) 이다
- DIP 개념으로 접근한 PartnerService 와 PartnerReader, PartnerRepository를 도식화하면 다음과 같다
  ![image](https://user-images.githubusercontent.com/28394879/144731135-4f6066c9-827d-45ce-bdde-8b2aff75aafc.png)
  - PartnerReaderImpl의 실제 구현은 Spring JPA를 활용하고 있지만, 추후 Spring JDBC 또는 MyBatis같이 다른 low level 구현을 사용하더라도 PartnerService에서는 특별한 변경 없이 사용이 가능하게 된다
- (추가) 순수한 도메인 모델과 ORM 사용에 대한 좋은 아티클
  - https://enterprisecraftsmanship.com/posts/having-the-domain-model-separate-from-the-persistence-model/
  - ORM을 사용하다보면 순수한 도메인 모델 (Entity)을 설계하고 구현하는 과정에서 제한을 두어야 하는 경우가 생긴다
  - 이를 극복하기 위해 별도의 DAO 클래스를 둘 수 있는데, DAO 관련 구현 비용은 비싸지 않게 유지하면서도 도메인 모듈을 순수하게 유지할 수 있다고 보여진다 -> 하지만 실제로는 그렇지 않다
  ![image](https://user-images.githubusercontent.com/28394879/144731169-b2186d03-5cae-4acb-aec8-e856fde236fe.png)
  - DDD에서 ORM은 구현의 복잡성과 도메인의 순수성 사이에서 적절한 트레이트 오프를 제공한다는 내용이다
  - Spring Data JPA는 그런 개념으로 접근해야 한다. 


### 2-3. Application, Interface 개요

#### 1. Facade 구현
- DDD에서 말하는 응용 계층의 정의는 다음과 같다
  - 수행할 작업을 정의한다 **(도메인 주도 설계 72P 참고)**
  - 도메인 객체가 문제를 해결하도록 지시한다
  - 다른 애플리케이션 계층과의 상호 작용을 한다
  - 비즈니스 규칙은 포함하지 않으며, 작업을 조정하고, 다음 하위 계층에서 도메인 객체의 협력을 위해 업무를 위임한다
  - 작업을 조정하기만 하고 도메인 상태를 가지면 안 된다 

- 여기에서 제안할 응용 계층의 구현은 아래와 같다
  - 비즈니스 결정을 내리진 않지만 수행할 작업을 정의해야 한다
  - 따라서 주로 transaction 으로 묶여야 하는 도메인 로직과 그 외의 로직을 aggregation 하는 역할로 한정 짓는다
  - 그리고 네이밍으로 Service와 구분 짓기 위해 Xxx**Facade**라는 접미사를 활용한다
    - Facade 패턴은 다양한 외부 인터페이스를 하나의 인터페이스로 통합하는 개념으로 사용되지만, 여기에서는 로직의 조합이라는 측면을 강조하기 위해 Facade를 차용한다

- 응용 계층에서 구현해야할 Partner 도메인의 요구사항을 구현한다
  - 외부에 전달할 요구사항을 온전히 만족하는 메서드를 구현한다
    - 보통 PartnerService에 정의된 인터페이스와 일대일 매칭되는 메서드가 도출된다
  - 그 중 파트너 등록의 경우, 등록 성공 후 해당 파트너에게 이메일로 등록 성공 알림을 보내는 요구사항이 있다
    - 파트너 등록 과정에서의 모든 도메인 로직은 하나의 transaction으로 묶여야 정합성에 이슈가 없다
    - 이메일 발송의 경우 발송에 실패하더라도 파트너 등록이 정상적으로 이루어졌다면 큰 문제가 안되는 상황이다
      - 이런 식의 요구사항에 대한 판단과 해석은 담당 PO 또는 기능의 사용자와 협의하면서 정한다
    - PartnerService와 NotificationService의 조합으로 요구사항을 만족시키는 구현을 완성한다
  - 응용 계층을 하나 더 둠으로써 도메인 계층에서 처리하기 애매한 요구사항을 충족할 수 있는 여유가 생긴다
    - 필요에 따라서 여러 개의 Info를 조합하여 만드는 Result 객체가 필요할 수 있다
    - 이 때에는 여러 개의 Service를 호출 한 후 이를 조합하는 Result 생성 로직이 생길수 있다 

#### 2. Controller 구현 
- DDD에서 인터페이스 계층의 역할은 다음과 같다   
  - 사용자에게 정보를 보여주고 사용자의 명령을 해석하는 책임을 진다 **(도메인 주도 설계 72P 참고)**
  - 외부 인터페이스 구현 기술에 관계없이 도메인 계층 로직을 호출하고 이에 대한 결과를 변환하여 응답으로 제공한다
  - HTTP API, gRPC, 비동기 메시징 등의 다양한 통신 방법을 사용할 수 있어야 한다


- 여기에서는 주로 HTTP API를 사용하고 필요에 따라서 메시지 기반의 비동기 통신을 사용한다

- 외부 인터페이스 계층 구현은
  - 서비스 전체의 시스템간 인터페이스 표준을 정의하고 그에 맞게 외부 호출과 응답이 정의되도록 구현해야 한다
  - 여기에서는 주로 사용할 HTTP API의 요청과 응답 표준음 다음과 같다
  ```
  /**
  API endpoint 는 /api/{version}/{도메인명} 의 패턴을 prefix 로 한다
  content-type 은 application/json 으로 한다
  **/
  // 성공 응답
  {
  "result": "SUCCESS",
  "data": "plain text 또는 json 형태의 데이터",
  "messsage": "성공 메시지",
  "error_code": null
  }
  // 실패응답
  {
  "result": "FAIL",
  "data": null 또는 json 형태의 데이터
  "messsage": "에러 메시지",
  "errorCode": "plain text"
  }
  ```
  - API 처리 결과에 따른 응답 형태는 다음과 같은 의미를 지닌다. 
  ```
  1. http status: 2xx 이면서 result: "SUCCESS"
  → 시스템 이슈 없고, 비즈니스 로직도 성공적으로 처리됨
  2. http status: 2xx 이면서 result: "FAIL"
  → 시스템 이슈 없고, 비즈니스 로직 처리에서 에러가 발생함
  → 예시: 중복 데이터가 이미 존재함 / 인증 이슈
  3. http status: 4xx 이면서 result: "FAIL"
  → 잘못된 request 가 전달됨
  → 예시: 필수 요청 파라미터 키를 전달하지 않은 경우
  4. http status: 5xx 이면서 result: "FAIL"
  → 시스템 에러 상황. 집중적으로 모니터링할 응답
  → 예시: 시스템 장애
  ``` 
  - 하단의 **API 응답 체계** 단락 참고

- partner 도메인의 API 구현은 다음과 같다
  - 동기식 http api로 구현한다
  - content-type은 application/json 으로 한다
  - API endpoint 는 **/api/{version}/partners** 의 패턴을 prefix로 한다

- partner 도메인의 API를 구현하기 전에 시스템 간의 일관된 응답 체계를 위한 공통 응답과 변환 로직을 구현한다
  - BaseException
  - CommonResponse
  - CommonControllerAdvice

- partner도메인의 API를 구현한다
  - 외부 서비스의 요청과 응답은 내부 도메인 로직을 처리하는 layer와 명확히 분리되어야 한다
    - 이를 위해 interface layer에서 사용할 dto를 정의하고, 해당 dto가 domain layer로 침투되지 않도록 유의해야 한다
    - 이를 위해 별도의 convert로직이 필요하다
      - request dto를 domain의 Command 또는 Criteria로 변환하는 로직과
      - doamain의 Info를 response dto로 변환하는 로직이 필요하다
      - 변환 로직을 dto 내에 구현하는 것은 응집도를 높이는 측면에서 좋은 구현이 된다
    - 인터페이스 계층에서만 사용할 dto를 정의한다
      - 이 때 static inner class를 적극 활용한다. 장점과 단점이 공존하나 여러 개의 dto를 목적에 맞게 묶어둘 수 있다는 장점이 더 크게 다가온다
      - Validation을 정의하고 @Valid를 선언한다
      - toCommand()를 활용한다
    - Facade를 호출하고 결과를 받아 API 응답에 맞게 변환한다
      - CommonResponse.success(response)
      - Facade 호출 과정에서 Exception이 발생하면 CommonControllerAdvice에서 이를 처리할 것이다
      - 그러므로 불필요한 try-catch는 선언할 필요가 없다
    - 외부 요청과 응답에 대한 일괄적인 로깅을 구현하면 추후 운영에 도움이 된다
      - 이 때 AOP를 활용한 로깅을 구현하면 Controller의 request, response를 로깅하기 위해 일일이 logger 붙이지 않아도 된다
      - 하단의 **로깅의 중요성** 단락 참고

#### 3. 로깅의 중요성
- 신규 서비스를 접하게 되면 가장 먼저 확인하는 것은 로깅에 대한 것이다
  - 중앙화된 로깅이 구축되어 있는지
  - 로깅 시에 남기는 항목이 무엇인지
  - 에러 발생 시 해당 로그를 통해 버그의 원인을 찾을 수 있는지
  - 로그 모니터링을 통해 적절한 시스템 알람이 전송되고 있는지
- 특히 API 레벨의 request, response 로깅은 추후 리펙토링에 필수 항목이 될 수 있다 
  - 테스트 코드가 적절히 작성되지 않은 시스템 환경에서는 API의 request, response 로그만이 시스템 개선을 가능하게 해준다
  - 문서화된 스펙보다 정확한 것은 API의 request, response 로그이다
- ELK + kafka 스텍은 생각보다 구축이 어렵지 않다
  - 자체적인 구축이 어렵다면 https://sentry.io 와 같은 로깅 및 애플리케이션 모니터링 서비스를 활용해도 좋다
  - 어떤 것을 사용하든지 시스템 전체를 파악하기 위한 로깅과 모니터링 수단은 갖춰야 한다
- 서비스를 이용하는 유저가 에러를 접하게 되면 개발팀은 이를 즉시 인지할 수 있어야 한다. 또한 이를 기반으로 빠르게 에러 상황에 대응할 수 있어야 한다 

#### 4. API 응답 체계 
- API의 응답 체계는 시스템 전체가 일관되고 명확한 형태를 가진다면, 어떠한 구조이든 문제가 되지 않는다
- 실제로 Google, Facebook, Naver와 같은 서비스도 각자 고유한 방식의 API 응답 체계를 가진다
  - Google의 경우 http status code를 적극적으로 활용한다
    - https://cloud.google.com/storage/docs/json_api/v1/status-codes
    - Successful requests return HTTP status codes in the 2xx range. Failed requests return status codes in the 4xx and 5xx ranges.
  - Facebook의 경우 http status code를 상세히 활용하지는 않는 편이다
    - https://developers.facebook.com/docs/graph-api/guides/error-handling
    - code와 error_subcode라고 별도로 정의한 값으로 에러를 표현한다
- 어떤 형태이든지 시스템 전체 API의 응답이 명시적이고 일관된 것이 중요하다

- 여기에서 구현하는 프로젝트에서는 - 아래와 같은 성공과 실패 응답 형태를 가진다
  ```
  /**
  API endpoint 는 /api/{version}/{도메인명} 의 패턴을 prefix 로 한다
  content-type 은 application/json 으로 한다
  **/
  // 성공 응답
  {
  "result": "SUCCESS",
  "data": "plain text 또는 json 형태의 데이터",
  "messsage": "성공 메시지",
  "error_code": null
  }
  3.2. partner 도메인 개발 (2) 7
  // 실패응답
  {
  "result": "FAIL",
  "data": null 또는 json 형태의 데이터
  "messsage": "에러 메시지",
  "errorCode": "plain text"
  }
  ``` 
- 여기에서 구현하는 프로젝트에서는 http status와 응답 값이 result를 적절히 섞어서 응답값에 아래와 같은 의미를 부여한다.
  ```
  1. http status: 2xx 이면서 result: "SUCCESS"
  → 시스템 이슈 없고, 비즈니스 로직도 성공적으로 처리됨
  2. http status: 2xx 이면서 result: "FAIL"
  → 시스템 이슈 없고, 비즈니스 로직 처리에서 에러가 발생함
  → 예시: 중복 데이터가 이미 존재함 / 인증 이슈
  3. http status: 4xx 이면서 result: "FAIL"
  → 잘못된 request 가 전달됨
  → 예시: 필수 요청 파라미터 키를 전달하지 않은 경우
  4. http status: 5xx 이면서 result: "FAIL"
  → 시스템 에러 상황. 집중적으로 모니터링할 응답
  → 예시: 시스템 장애
  ```
- Spring Boot 에서는 ControllerAdvice라는 개념을 두어 시스템 전역에서 발생하는 예외를 처리할 수 있게 한다
  - Controller가 처리하는 API 호출 과정에서 Exception이 발생할 경우, Exception을 catch 하여 별도의 처리를 해야 할 필요성이 없다면 -> ControllerAdvice 까지 Exception 넘어오도록 그대로 throw 하는 것이 좋다
  - ControllerAdvice에서는 Exception을 catch 하여 시스템에서 정의한 API 응답에 맞게 응답을 정의하여 내려준다
  - 코드 상의 CommonControllerAdvice에서는 별도로 정의한 BaseException을 확장한 Exception이 발생하는 경우, 코드를 구현한 개발자가 이미 인지한 예외상황이라고 판단하여 http status : 200에 result : FAIL을 내려준다
  - BaseException을 확장하지 않은 예상치 못한 Exception이 발생하는 경우, http status: 500 을 내려주어 전사 모니터링에서 트래킹 되도록 하고 적절한 알람이 noti되도록 처리한다
![image](https://user-images.githubusercontent.com/28394879/144834630-60c31958-17fc-4882-b51f-8044ef756605.png)


</details>

<details><summary> 3. Item Domain 개발 </summary>

## 3. Item Domain 개발 

### 요구사항
- 시스템에 등록되고 활성화된 파트너는 상품을 등록할 수 있다
- 등록된 상품은 유저가 주문을 받아 판매될 수 있다
- 상품은 상품명, 가격 등의 기본 정보와 색상, 사이즈와 같은 옵션으로 구성된다
- 상품은 옵션 정보 없이 기본값으로만 저장될 수도 있다
- 주문 화면에서 보여지는 상품의 옵션은 파트너사가 원하는 순서에 맞게 노출될 수 있어야 한다
- 상품 구매 시 특정한 옵션을 선택하면 가격이 추가될 수 있다
- 상품은 판매 준비중, 판매중, 판매 종료와 같은 상태를 가진다
- 그 외 시스템을 사용하는 유저가 기본적으로 기대하는 기본 기능들 - 조회, 등록, 수정, 삭제 등의 기능을 제공해야 한다
- **여기에서는 실제의 복잡한 상품 도메인 요구사항을 간소화 하였다. (수량 등의 속성 생략)**

### 도메인 계층 설계 및 구현 (domain package)
#### DDD 의 Aggregate
**(도메인 주도 설계 133p ~ 139p 참고)**  
- 상품 도메인은 아래의 Entity로 구성된다
  - Item
  - ItemOptionGroup
  - ItemOption

- 이 중 Item은 Item 도메인 전체의 Aggregate Root 역할을 한다
  - Item Aggregate 경계 밖에서는 Item을 제외한 Aggregate 내부 구성요소를 참조할 수 없다
  - Item을 획득하면 Aggregate 내부의 객체를 탐색해서 획득할 수 있게 된다
  - Item Aggregate 내부에서는 데이터가 변경될 때 마다 유지돼야 하는 일관된 규칙이 지켜져야 한다
  - 일관된 규칙은 Aggregate Root에 적용되는 모든 트랜잭션 내에서 지켜져야 한다 -> 규칙이 깨진다면 트랜잭션 롤백이 발생한다는 것
  - 하단의 **DDD 에서의 Aggregate** 단락 참고

- Item Aggregate를 만들어내는 과정에서 Factory의 사용을 검토한다
  - Item 도메인의 경우 객체 생성 과정에서 Item 뿐만 아니라 OptionGroup 과 Option의 정합성이 일관되게 지켜져야 한다
  - 이 과정에서 각 클래스의 생성자만으로는 Item Aggregate 생성 과정의 복잡한 규칙을 표현하기 어렵다
  - 자신의 책임과 역할이 다른 객체를 생성하는 프로그램 요소를 Factory라고 하는데, 복잡한 객체와 Aggregate 인스턴스를 생성하는 책임을 맡기기에 적합하다
    - 여기에서는 Item 도메인 내에 ItemOptionSeriesFactory를 정의하고 Implements영역에는 해당 Factory를 활용한다
    - Factory의 역할에서 객체를 데이터베이스와 같은 저장소에 영속화시키는 것은 포함되지 않는다. 이에 대한 역할은 Repository가 가져간다
  - 하단의 **Factory 와 Repository** 단략 참고
- 아래는 Item Aggregate를 표현하는 클래스 다이어그램이다
  ![image](https://user-images.githubusercontent.com/28394879/144949655-1df1b0cc-4a4d-46e2-af70-a6afc756223b.png)

- 아래는 디자인된 주문 화면의 예시이다 
  ![image](https://user-images.githubusercontent.com/28394879/144949702-d063fb34-bb97-4c91-a564-b41b8bbb1d5d.png)

- Item Aggregate와 실제 상품과 옵션값의 예시 매핑은 아래와 같다.
  ![image](https://user-images.githubusercontent.com/28394879/144949827-2aed9bce-c18f-44bc-b289-194ddad95af2.png)


### Entity 구현
- 요구사항을 기반으로 Item 과 ItemOptionGroup, ItemOption의 필수 속성과 메서드를 정의하고 구현 방향을 정의한다
  - 필수 속성
    - itemToken **(대체키)**
    - partnerId
    - name
    - price
    - status
    - ordering
  - 필수 메서드
    - 상품 상태 변경
- Item과 ItemOptionGroup, ItemOption 간의 연관관계를 설정한다
  - OneToMany, ManyToOne 등의 연관관계를 설정하여 객체 간의 참조 관계를 명확히 알 수 있도록 한다
    - ManyToOne만으로 객체 관계를 설정하는 것이 단방향을 유지하고 성능 측면에서도 좋겠지만
    - 실제 도메인 로직 구현 과정에서는 OneToMany 사용에 대한 장점이 있기 떄문에 적절한 타협이 필요하다
    - 여기서는 OneToMany와 ManyToOne을 함께 사용하여 성능상의 이슈를 없애고, 양방향 참조로 인해 발생할 수 있는 버그 상황은 피하도록 한다
  - 하단의 **연관관계 설정** 단락 참고

### Service 및 Implements 구현
- ItemService <Interface> 에서 제공해야 하는 요구사항을 정의한다
  - 상품 등록
  - 상품 정보 조회
  - 상품 판매 가능 상태로 변경
  - 상품 판매 불가능 상태로 변경


**상품 등록의 경우**
- Item Aggregate 생성을 위한 Factory를 구현한다
  - 각 객체의 필수값 여부를 확인하고, 각 객체간의 부모 자식 관계를 설정하는 생성 과정은 하나의 생성자 안에서 처리하기에는 복잡도가 높다
    - ItemOptionGroup 생성 시에는 Item의 reference가 필요하고, ItemOption에서는 ItemOptionGRoup의 reference가 요구된다
    - 그렇기 때문에 하나의 트랜잭션 안에서 Item, ItemOptionGroup, ItemOption을 순차적으로 생성하는 구조를 가지게 된다
    - 또 경우에 따라서 Option 정보가 없는 상품의 경우는 Item만 독립적으로 생성하게 된다
  - Option 계열의 복잡한 객체 생성 로직은 ItemOptionSeriesFactory에서 구현하고, 도메인 서비스에서는 적절한 추상화를 통해 가독성을 유지하도록 한다
    - Factory 생성의 범위를 Aggregate 전체로 할 수도 있지만, 여기에서는 Option 계열의 Factory만으로 한정 짓는다
    - 이를 통해 1) Item 생성 후에 2) Option 계열의 Entity를 생성한다는 도메인 로직을 표현하고 싶었다
- 생성 과정에서 Item Entity의 필수 파라미터인 partnerId의 획득 과정을 살펴보자
  - 서버 바깥의 프론트엔드에서는 partnerId가 아닌, partnerToken을 전달했을 것이다
  - partnerToken으로 Partner 객체를 로딩 한 후, 그것을 통해 partnerId를 획득한다
  - Item Entity에서 partnerToken가 아닌 partnerId를 저장했지만 partnerToken으로 저장해도 무방하다
    - partnerToken으로 저장하면 Item Aggregate 생성 과정에서 partner 객체 조회 쿼리를 호출하지 않아도 되고
    - partnerId로 저장하면 table내에서 item 정보를 확인할 때 token 보다는 한눈에 읽기 쉽다는 장점이 있다
**상품 조회의 경우**  
- 우선 itemToken으로 Item Aggregate의 Root가 되는 Item을 조회한다
- 이를 기반으로 ItemInfo 객체를 생성 후 리턴한다
  - ItemInfo 객체는 데이터베이스에서 조회하여 가져온 Entity를 그대로 리턴하지 않기 위한 객체이다
  - ItemInfo 객체는 Item Aggregate의 매핑이 가능하도록 적절히 구조화하여 생성한다
  - **1 : N : N**의 구조를 가지는 **Item : ItemOptionGroup : ItemOption**를 생각 할 때, 두 번의 stream 구문으로 ItemInfo 객체 생성이 가능하다
- 구현이 완료되면 리펙토링을 진행한다
  - Item Aggregate와 ItemInfo간에는 반복적인 파라미터 매핑 코드가 존재하게 된다
  - 이런식의 boilerplate 코드를 줄이기 위해 매핑 라이브러리를 사용한다
  - 여기에서는 MapStruct라는 오픈소스를 사용할 것이다
  - 하단의 **MapStruct 사용** 단락 참고 

### 응용 계층, 외부 인터페이스 계층 구현(application, interfaces package)

#### Facade 구현
- Item Facade에서는 item domain에서 요구사항을 처리하도록 domain service를 호출하는 이상의 역할은 없다
- 이런 경우 Controller에서 곧장 Service를 호출할 수도 있지만, 추후의 요구사항 대응을 위한 buffer를 생각할 때 Facade를 유지하는 것이 낫다. 여기에서는 Facade를 사용한다
  - 프로젝트 전체의 구조 유지
  - 추후 요구사항 추가 및 변경이 대응에 용이함

#### Controller 구현
- Item Aggregate 생성을 위한 request dto와 ItemInfo 조회 시 사용할 response dto는 Item Aggregate 만큼 복잡한 구조를 가진다
  - 이런 경우 dto를 domain측 객체로 변환 시 bolierplate code가 많이 생길 수 있다
  - 이는 MapStruct를 사용하여 해결한다

---

### DDD에서의 Aggregate
**(도메인 주도 설계 133p ~ 139p 참고)**  

**필요성** 
- 모델 내에서 복잡한 연관관계를 맺는 객체를 대상으로 일관된 규칙을 보장하기는 쉽지 않다
- 개별 객체만이 아닌 서로 밀접한 관계에 있는 객체 집합에도 변경에 대한 일관된 규칙 (=불변식) 이 유지되어야 하기 때문이다
- 이를 위해 Aggregate를 구성하고 Aggregate에 적용되는 불변식은 각 트랜잭션이 완료될 때 이행되도록 한다

**특징**
- Aggregate는 데이터 변경의 단위로 다루는 연관 객체의 묶음을 말한다
- 각 Aggregate에는 루트(Root)와 경계(Boundary)가 있는데
  - 경계는 Aggregate에 무엇이 포함되고 포함되지 않는지를 정의한다
  - 루트는 단 하나만 존재하며, Aggregate에 포함된 특정 Entity를 가리킨다
- 각 루트 Entity는 전역 식별성을 지니고, 경계 안의 Entity는 지역 식별성을 지닌다
- Aggregate 경계 밖에서는 루트 Entity를 제외한 Aggregate 내부의 구성요소를 참조할 수 없다
- Aggregate 경계 안의 어떤 객체를 변경하더라도 전체 Aggregate의 불변식은 모두 지켜져야 한다

즉, Aggregate는 생명주기의 전 단계에서 불변식이 유지되어야 할 범위를 표시해준다

### Factory와 Repository
**(도메인 주도 설계 140p ~ 167p 참고)**  
#### Factory
**필요성**  
- 복잡한 객체를 생성하는 일은 도메인 계층의 책임이지만, 그것이 모델을 표현하는 객체에 속하는 것은 아니다
  - 자동차를 조립하는 것과 자동차를 운전하는 것은 다른 영역의 것이다. 결코 동시에 일어날 수 없는 일이다
- 그렇다고 객체의 생성을 클라이언트에 두면 Aggregate의 캡슐화를 위반하고 클라이언트의 설계가 지저분해지게 된다
- 복잡한 객체와 Aggregate의 인스턴스 생성을 책임지는 별도의 객체를 선언하여 운영하는 것이 필요하다

**특징**  
- 자신의 책임과 역할이 다른 객체를 생성하는 것인 프로그램 요소를 Factory라고 한다
- Factory는 해당 Factory에서 만들어내는 객체와 매우 강하게 결합돼 있으므로, 자신이 생성하는 객체와 가장 가까이 있어야 한다
- Factory는 Aggregate에서 유지되어야 할 불변식 로직을 Factory내에 둬서 Aggregate내에 들어 있는 복잡한 요소를 줄일 수도 있다


특정 객체나 Aggregate를 생성하는 일이 복잡해지거나 내부 구조를 너무 많이 드러내는 경우 -> Factory를 사용한다

#### Repository
**필요성**
- 객체를 이용해 뭔가를 하려면 해당 객체에 대한 참조를 가지고 있어야 한다
- 클라이언트는 이미 존재하는 도메인 객체의 참조를 획득할 수 있는 실용적인 수단을 필요로 한다
  - 해당 객체의 속성을 활용하여 검색하는 식으로 객체의 참조를 획들할 수 있어야 한다
  - 이 때 마음대로 데이터베이스에 질의를 수행하면 도메인 객체와 Aggregate의 캡슐화를 어기는 질의를 수행할 수도 있게 된다
- Repository는 이와 같은 로직을 캡슐화하여 구현에 있어서 모델에 집중할 수 있게 해주는 개념적 틀에 해당한다

**특징**
- 클라이언트는 지정된 기준에 근거해 객체를 선택하는 질의 메서드를 이용해 Repository에서 객체를 요청하게 된다
- 데이터베이스 관련 기술은 다양하고 복잡한데 이를 Repository인터페이스로 도출하면 클라이언트는 단순하고 의도가 드러나는 구현이 가능하고 실제 복잡한 구현은 인프라스트럭쳐에 맡길 수 있다
- 즉, 객체를 추가하거나 제거하고 조회하는 기술을 캡슐화하여 제공하는 것이 Repository의 특징이다

Factory가 새로운 객체를 만들어 내는데 반해 Repository는 기존 객체를 찾아낸다

### 연관관계 설정
- 객체와 객체, 테이블과 테이블이 연관관곌르 맺는 것에는 근본적인 차이가 있따
  - 팀과 회원이라는 개념으로 둘 가느이 차이를 비교하면 다음과 같다
    - 하나의 팀에 여러 명의 회원이 포함된다는 개념을 생각하면 팀과 회원의 관계는 **팀 : 회원 = 1 : N**의 관계가 된다
    - 객체의 경우 2개의 연관관계가 생긴다
      - 팀 -> 회원의 연관관계 1개
      - 팀 <- 회원읜 연관관계 1개
    - 테이블의 경우, 회원 테이블에 팀 PK를 가짐으로써 (외래키) 양방향 연관관계가 생긴다
      - 팀 <--> 회원 연관관계
- 객체의 일대다, 다대일 관계에서 연관관계의 주인은 외래킬르 관리하는 곳이 주인이 된다
  - 테이블 기준으로 생각해뽀면 회원 row 마다 팀의 PK를 가질수는 있어도
  - 하나의 팀 row 에서 팀에 속한 여러 회원의 PK를 가질 수는 없다 
  - 연관관계의 주인은 외래키를 가지게 되는 N쪽이라고 생각할 수 있고, 여기서는 회원쪽이 연관관계의 주인이 된다
- OneToMany를 써야 하는 경우는 정말 많음에도, JPA 동작 원리상 OneToMany만을 사용하는 것은 권장하지 않는다
  - OneToMany는 연관관계의 주인이 되는 외래 키가 다른 테이블에 있다
  - 이런 구조 떄문에 연관관계 데이터가 변경되는 과정에서 불필요한 update가 실행된다
- OneToMany의 성능 이슈를 해결하고 실무에서 사용하고자 한다면, OneToMany와 ManytoOne을 함께 사용하면 된다
  - 관련하여 mappedBy 와 JoinColumn등을 정확히 선언하여 사용한다
  - Service 메서드에서는 Entity를 그대로 리턴하지 않고 Entity를 적절히 변환한 객체 (여기서는 Info)를 리턴하도록 한다
  - 예제 프로젝트에서 Item 과 ItemOptionGroup간의 매핑 코드는 다음과 같다
    - Item 코드
      ![image](https://user-images.githubusercontent.com/28394879/144953111-1df5368d-ff8c-4fac-a4f0-60b1047e2617.png) 
    - ItemOptionGroup 코드  
       ![image](https://user-images.githubusercontent.com/28394879/144953155-172048d9-fb13-4bac-bba3-c47c7af54fba.png)

### MapStruct 사용
- 복잡한 애플리케이션을 여러 개의 계층(이하 Layer)으로 나누어 개발하는 것은 각 계층의 관심 측면만을 전문적으로 다룬다는 점에서 의의가 있다
  - 이 떄 각 Layer 마다 사용하고 전달되는 객체는 적절한 컨버팅 로직을 통해서 격리되고 변환되어야 한다
  - 특정 Layer에서 사용되는 객체가 다른 Layer로 전달되는 과정에서 적절한 컨버팅이 없다면 Layer간의 의존 관계가 꺠질 수도 있다
  - 경우에 따라서는 특정 기술 사용에 따른 예상치 못한 예외가 발생할 수도 있다 (Spring JPA 기반의 lazy loading 관련한 예외 등등)
- Layer 간의 객체 변환 로직은 개발자가 일일이 직접 구현해도 되지만
  - 반복적이고 불필요한 코드가 많아지게 되고
  - 단순한 실수로 인한 개발 생산성이 떨어지게 된다

- 이를 위해 많이 사용하는 매핑 라이브러리는 ModelMapper가 있는데, 여기에서는 MapStruct라는 라이브러리를 사용하고자 한다
  - 동작 방식의 차이
    - ModelMapper는 리플렉션 기반으로 동작하여 실제 매핑 로직을 쉽게 파악하기 어려우나
    - MapStruct는 코드 생성 방식으로 동작하기 떄문에 생성된 코드를 통해 매핑 로직을 쉽게 파악할 수 있다
    - MapStruct는 컴파일 타임에 매핑 오류를 인지하고 설정에 따라 빌드 시 에러를 던질 수도 있다
  - 성능 측면에서
    - MapStruct가 훨씬 더 좋다고 알려져 있다
- MapStruct 사용 방법
  - 의존성 추가
    - build.gradle에 다음과 같은 dependency를 추가한다
    ![image](https://user-images.githubusercontent.com/28394879/144953715-5f7ecbe8-bf83-4001-8b6c-c9cd2328ee00.png)
    - https://mapstruct.org/documentation/stable/reference/html/#_gradle 참고
    - https://mapstruct.org/documentation/stable/reference/html/#lombok 참고
  - 매핑 선언
    - 특별한 구현 없이 Mapper Interface만 정의하면 컴파일 과정에서 해당 인터페이스의 구현체를 생성한다
      - https://mapstruct.org/ 의 [MapStruct in 2 Minutes] 참고
    - source와 target의 attribute가 완전히 동일한 경우
      - Mapper Interface 내부에 source와 target만 선언하면 된다
          ![image](https://user-images.githubusercontent.com/28394879/144953887-d4d4f162-7e9d-41c9-95dc-ce305fb468b8.png)
    - source와 target의 type은 동일하나 attribute가 약간 다른 경우
      - 별도의 매핑 선언이 필요한 attribute 만 정의하면 된다
         ![image](https://user-images.githubusercontent.com/28394879/144953955-d2516687-f60e-45f0-a486-5d2101b24234.png)
    - 매핑 로직에서 java expression 사용이 필요한 경우
      - java 키워드를 선언한 후 해당 로직을 작성하면 된다
        ![image](https://user-images.githubusercontent.com/28394879/144954016-5c9f939f-7e50-42f1-a72d-ccbbba9f89cd.png)
      - Intellij의 MapStruct Support Plugin을 활용하면 java expression 작성시의 오타를 방지할 수 있다 
        ![image](https://user-images.githubusercontent.com/28394879/144954110-42f7cd1a-6640-448b-9838-ac0593e39247.png)
    - 매핑 대상 객체에 Collection 요소가 포함된 경우
      - Collection 요소에 대한 매핑 로직을 초가로 선언해야 한다
      - Main 클래스 내에 List<OrderItem> 이라는 Collection이 존재하기 떄문에 Main 클래스에 대한 매핑 로직 선언 시, OrderItem에 대한 매핑 로직도 같이 선언해야 한다 
        ![image](https://user-images.githubusercontent.com/28394879/144954232-d8316674-6bf4-4ef4-81e7-e7b2df7d4660.png)
        ![image](https://user-images.githubusercontent.com/28394879/144954260-4f844f6a-e536-4360-a425-b5fa5f7e66b9.png)
      - https://mapstruct.org/documentation/stable/reference/html/#mapping-collections 참고


   

</details>

<details><summary> 4. Order Domain 개발 </summary>

## 4. Order Domain 개발

### 요구사항
- 시스템에 등록된 상품은 유저가 주문할 수 있다
- 주문은 주문 등록, 결제, 배송 준비, 배송중, 배송 완료의 단계를 가진다
- 주문 등록 과정에서는 결제 수단을 선택하고 상품 및 상품 옵션을 선택한다
- 시스템에서 사용 가능한 결제수단은 1) 카드 2) 토스페이 3) 카카오페이 4) 네이버페이 등이 있다
- 결제 과정에서는 유저가 선택한 결제수단으로 결제를 진행한다
- 결제완료 후 유저에게 카카오톡으로 주문 성공 알림이 전달된다
- 결제가 완료되면 배송준비 단계로 넘어간다
- 배송중, 배송완료의 단계도 순차적으로 진행된다
- **여기에서는 실제의 복잡한 주문 도메인 요구사항을 간소화 하였다 (취소 및 결제 PG 연동 등의 요구사항 생략)**

### 도메인 계층 설계 및 구현 (domain package)
#### Entity 구현
- 아래의 Order Aggregate를 표현하는 클래스 다이어 그램이다. 
  ![image](https://user-images.githubusercontent.com/28394879/145013478-fae09971-a9c4-4bdf-9899-835b269839e2.png)

- 요구사항을 기반으로 Order와 OrderItem, OrderItemOptionGroup, OrderItemOption의 필수 속성과 메서드를 정의한다
  - 필수 속성
    - orderToken **(대체키)**
    - userId
    - payMethod
    - status
    - orderedAt
    - 배송시 관련 정보군 (DeliveryFragment)
    - 주문 상품의 item 군 필수 속성
  - 필수 메서드
    - 주문 상태 변경
    - 주문 총 가격 계산
  - 주문 상태 (status)
    - INT - 주문 시작
    - ORDER_COMPLETE - 주문완료
    - DELIVERY_PREPARE - 배송준비
    - IN_DELIVERY - 배송중
    - DELIVERY_COMPLETE - 배송완료
  - Order와 OrderItem과 OrderItemOptionGRoup, OrderItemOption 간의 연관관계를 설정한다
    - Order를 Aggregate Root로 하여 하위 객체들을 1:N 관계로 매핑한다
    - 앞에서 정의한대로 OneToMany, ManyToOne 양방향 참조로 설정하고 성능과 관계 설정의 타협점을 찾는다 

#### Service 및 Implements 구현
- OrderService <Interface> 에서 제공해야 하는 요구사항을 정의한다
  - 주문 등록
  - 주문 결제
  - 주문 조회
  - 배송 준비중
  - 배송중
  - 배송완료

**주문 등록의 경우**  
- Item Aggregate와 마찬가지로 1) Order 생성 후에 2) Order 안에 포함된 OrderItem 계열의 Entity를 생성한다
- 주문 Aggregate를 생성하는 과정에서 validation check는 필수 로직이다. validation check 구현 형태는 크게 두 가지로 나뉠 수 있을 것이다
  - 1) Entity 자체에서 확인이 가능한 것과 2) 별도의 Service에서 확인이 가능한 것
  - 1) Entity 자체에서 확인이 가능한 것은
    - 필수 프로퍼티의 존재 여부 체크이다
    - 이는 OrderCommand와 Order의 생성자 내에서 필수값 존재 여부를 체크하면 된다
    - 외부 Service의 도움이 필요 없다 
  - 2) 별도의 Service 에서 확인이 가능한 것은
    - 외부에서 전달된 주문 금액과 DB에 저장된 주문 상품의 금액과의 일치 여부 체크, 파트너 또는 상품이 판매 가능한 상태인지 체크 등이다
    - 외부에서 전달된 itemToken으로 item을 조회한 후에, 외부에서 전달된 itemPrice와 비교하여 가격의 일치 여부를 체크한다
    - 이런 경우 itemReader와 같은 외부 Service의 도움이 필요하다
  - validation의 경우
    - Aggregation 내에 포함시켜서 전체 로직의 응집도를 높이는 것이 좋겠지만
    - Aggregation 전체를 생성하는 Factory내에 두어서 Aggregation의 복잡도를 줄일 수도 있다
    - 또는 validation을 처리하는 별도의 구현체를 두고 Entity 생성 로직 과정에서 이를 활용할 수도 있다

**주문 결제의 경우**
- 로직의 논리적인 순서상 다음과 같은 flow를 가지게 된다
  - orderToken 으로 주문 정보를 가져온 후
  - 외부의 결제 서비스를 활용하여 실제 결제 과정을 처리하고
  - 이후 주문 상태를 주문완료로 변경한다
  - (이상 위의 순서를 flow#1 이라고 지칭한다)
    ![image](https://user-images.githubusercontent.com/28394879/145015401-bcde5e6b-1ad5-471e-8fa9-b3cbc4a15c5e.png)
  - 다만 논리적인 순서와 다르게 데이터의 정합성 측면에서 아래와 같은 순서로 서비스를 처리한느 것이 좋을 수 있다
    - orderToken 으로 주문 정보를 가져온 후 
    - **주문 상태를 주문완료로 변경하고**
    - **이후 외부의 결제 서비스를 활용하여 실제 결제 과정을 처리한다**
    - (이상 위의 순서를 **flow#2** 이라고 지칭한다)
    ![image](https://user-images.githubusercontent.com/28394879/145015667-8dfe9625-1b0b-4c9e-9d00-de88025efd74.png)
- 로직마다 에러 발생 가능성이 어디가 더 높은지, 한번 실행된 로직의 rollback이 수월한지를 따져본다면 **flow#2**가 좀더 나은 구현이라고 생각 할 수도 있다
  - **flow#1**의 실행 과정에서 order.orderComplete() 에서 Exception이 발생했다고 가정해보자 (RuntimeException)
  - paymentOrder는 하나의 transaction으로 묶여있기 때문에 전체 메서드는 rollback이 된다
  - 그러나 paymentProcessor의 경우 외부 서비스 Api CAll이기 때문에, 정상적으로 호출이 되었다면 transaction이 rollback되더라도 변경되고 처리된 데이터는 rollback 되지 않는다. 즉, 주문은 complete 처리되지 않았지만 유저의 돈은 이미 지불되었다는 것이다
  - 이를 해결하려면 try-catch 구문을 활용하여 catch 구문 내부에서 보상 트랜잭션 API (유저의 결제 금액 환불)를 호출해야 한다. 이는 로직의 복잡도를 증가시킨다
  - 결제의 논리적인 순서와는 약간 다르겠지만 order.orderComplete()과 paymentProcess.pay()의 호출 순서만 바꿔주면, 실행 과정에서 Exception이 발생하더라도 외부 서비스를 위한 보상 트랜잭션 API은 호출하지 않아도 된다 (외부 서비스 API 가 아직 실행되지 않았기 떄문에)
  - 또한 paymentProcess.pay() 실행 중에 예외가 발생했으면 order.orderComplete()의 실행 결과도 rollback 될 것이기 때문에 데이터 정합성은 유지된다
- 도메인 로직 처리 과정에서 이전 단계에서 완료한 모든 작업을 실행 취소해야 하는 경우가 있다
  - 예를 들어 주문 처리 과정에서 상품의 재고를 차감했는데 결국 주문 처리가 정상적으로 이루어지지 않았따면 -> 재고도 원복해야 한다
  - 과거에는 분산 트랜잭션 (2PC) 등을 이용해서 여러 서비스의 데이터 처리를 전역 트랜잭션으로 묶어서 커밋과 롤백이 가능하게 했따면
  - 서비스 간의 독립적을 중시하는 msa 구조에서는 이런 상황을 보상 트랜재겻ㄴ으로 처리한다
    - 즉, 주문 처리가 실해했다면 그 전 단계에서 차감했던 재고 수량을 원복하는 API를 다시 호출하는 방식을 말한다
  - 하단의 **보상 트랜잭션** 단락 참고
- 결제 처리는 유저가 선택한 결제 수단에 맞는 PaymentProcessor 가 처리하게끔 한다
  - 시스템에서 제공하는 결제 수단은 1) 카드 2) 토스페이 3) 카카오페이 4) 네이버페이 - 4가지 이다
  - 구체적인 구현으로 들어간다면 각 결제 수단마다 결제를 처리하는 parameter와 flow가 다 다르겠지만
  - 도메인 로직에서는 이를 추상화하여 "해당 주문의 결제를 처리한다"라는 서비스의 흐름을 한 눈에 아가할 수 있도록 해야 한다
    - 세세한 구현은 Service가 아니라 infrastructure의 PaymentProcessor 클래스에 위임하고, Service 도메인에서는 이를 활용하기 위한 Interface를 선언하고 상요한다
    - DIP 개념을 활용하여 도메인이 사용하는 Interface의 실제 구현체를 주입 받아 (Injection) 사용할 수 있도록 한다
    - 이렇게 하면 하나의 Service 메서드를 읽기만 해도 도메인의 흐름을 파악할 수 있고, 세부 구현은 새로운 구현체를 Injection하여 쉽게 변경할 수 있다
  - PaymentProcessor는 주문의 결제를 처리하는 객체이고 아래와 같은 세부 구현을 가진다
    - PaymentValidator - 결제 과정에서의 validation check
    - PaymentApiCaller - 결제 수단에 맞는 ApiCaller 호출
    - Spring이 제공하는 DI 기능을 활용하여 각각의 인터페이스를 구현한 구현체를 List로 받아 활용한다
    - PaymentValidator interface의 경우 - 아래와 같은 메서드 시그니처를 선언하고, 다양한 validation 요구사항을 커버하는 각각의 validation 구현체를 생성하여 활용한다
      ```java
      public interface PaymentValidator {
      void validate(Order order, OrderCommand.PaymentRequest paymentRequest);
      }
      ``` 
      - 예제 구현에서는 
        - 주문 가격 체크 Validator
        - 결제 수단 체크 Validator
        - 주문 상태 체크 Validator 를 구현하였다
    - PaymentApiCaller interface의 경우 - 아래와 같은 메서드 시그니처를 선언하고, 다양한 결제수단 구현체를 생성하여 활용한다
      ```java
      public interface PaymentApiCAller {
        boolean support(PayMethod payMethod);
        void pay(OrderCommand.PaymentRequest request);
      }
      ``` 
      - support 메서드는 전달된 PayMethod를 자신이 처리할 수 있는지(=support 할 수 있는) 판별하는 return 값 boolean의 메서드이다
      - pay메서드는 전달된 paymenRequest를 활용하여 실제적인 결제 과정을 처리하는 메서드이다
      - 예제 구현에서는
        - 카드
        - 토스페이
        - 카카오페이
        - 네이버페이를 구현하였다 (실제의 pay 메서드는 구현하지 않음)
    - PaymentProcessor를 중심으로 한 클래스 다이아그램은 아래와 같다
      ![image](https://user-images.githubusercontent.com/28394879/145018736-3f21adbf-b039-4a0b-a55a-fd3eefc2178c.png)
    - validation 과정에서 사용되는 주문 가격의 총 금액을 계산하는 로직의 구조는 다음과 같다
      - 주문의 총 금액은 Order Aggregate의 Root인 Order가 계산한다
      - 주문에 포함된 OrderItem 각각의 가격 총합을 구해야 한다. 이는 OrderItem의 calculateTotalAmount() 에서 계싼한다
      - OrderItem의 가격은 각각 Item과 ItemOption의 가격의 합으로 이루어진다. 그렇기 때문에 calculateTotalAmount()에서 각각의 Item과 ItemOption의 가격의 합을 계산한다
      - OrderItem.calculateTotalAmount()의 로직은 아래와 같다
        ```java
        public Long calculateTotalAmount() {
        var itemOptionTotalAmount = orderItemOptionGroupList.stream()
        .mapToLong(OrderItemOptionGroup::calculateTotalAmount)
        .sum();
        return (itemPrice + itemOptionTotalAmount) * orderCount;
        }
        ``` 
      - PayAmountValidator에서 사용하는 주문 가격 계산 과정에서의 객체간 상호 작용은 다음과 같다
        ![image](https://user-images.githubusercontent.com/28394879/145019612-c5d26e0f-a2ab-4bdf-8a22-2f416af6ba0c.png)


**주문 조회의 경우**  
- Order와 OrderItemList를 조회한 후에 
- Mapper를 이용하여 OrderInfo 객체로 변환하여 리턴한다

**그 외 배송 관련 로직은 설명에서 생략 - 간단한 코드로 대체**
- 배송업체와 서비스 간의 flow를 생각하여 그림을 제공하기
  - 배송 준비중 / 배송중 / 배송완료 는 각각 수신자가 다르다


### 응용 계층, 외부 인터페이스 계층 구현 (application, interfaces package)
#### Facade 구현
- Order Facade 에서는 order domain에서 요구사항을 처리하도록 domain service를 호출하는 이상의 역할은 없다
- 이런 경우 Controller에서 곧장 Service를 호출할 수도 있지만, 추후의 요구사항 대응 buffer를 위해 Facade를 유지하는 것이 나을 수도 있다. 여기에서는 Facade를 사용한다
  - 프로젝트 전체의 구조 유지
  - 추후 요구사항 추가 및 변경의 대응에 용이함

#### Controller 구현
- Order Aggregate 생성을 위한 request dto와 OrderInfo 조회 시 사용할 response dto는 Order Aggregate 만큼 복잡한 구조를 가진다
  - 이런 경우 dto를 domain측 객체로 변환 시 bolierplate code가 많이 생길 수 있다
  - 이를 MapStruct를 사용하여 해결한다

---

### 보상 트랜잭션 
- msa 환경에서는 하나의 프로세스를 완성하기 위해서는 여러 도메인의 연산을 모두 처리해야 하는 경우가 있다
  - 가령 주문 완료의 경우
    - 물류창고에서 물품을 확인하고
    - 유저 결제를 완료 시킨 후에 
    - 멤버십에 포인트를 부여하고
    - 물품 배송을 시작하는 프로세스를 모두 처리해야 한다
  - 그런데 만약 하나의 프로세스를 처리하는 중간 과정에서 에러가 발생했다면
    - monolithic구조에서는 모든 프로세스가 하나의 트랜잭셔능로 묵였을 것이기 때문에 rollback 처리가 간단하지만
    - msa 구조에서는 에러 발생 직전의 중간 프로세스에서는 API 호출을 통해 처리가 완료 되었을 것이라서 전체 rollback이 쉽지 않다
    - msa 의 분산 트랜잭션 구조에서 프로세스 rollback을 위해 등장하는 개념이 **보상 트랜잭션**이다
  - **보상 트랜잭션**은 이전에 커밋된 트랜잭션을 취소하는 연산이다
    - 결제가 완료된 프로세스는 결제를 취소하는 연산을 발생시키고 
    - 포인트를 부여했다면 포인트를 다시 회수하는 식의 연산을 발생시키는 것이다
  - 하지만 이런 **보상 트랜잭션**은 일반적인 데이터베이스 롤백과는 완전히 일치하지는 않는다
    - 이미 실행된 작업을 회수하는 개념이 아니라 추가적인 실행을 통해 기존 작업을 보완하는 방식에 가깝다
    - 주문 완료 메일이 발생되었다면 메일을 회수하는게 아니라 주문 취소 메일을 다시 보내는 방식이다
  - 경우에 따라서는 프로세스 내의 연산 순서를 조정하여 **보상 트랜잭션**의 발생 횟수 자체를 줄일 수도 있다
    - 외부 서비스 API 호출과 같이 -> 예외 발생 가능성이 높은 프로세스를 가장 먼저 실행하거나
    - Entity의 상태 변경과 같이 -> 데이터베이스 롤백이 쉬운 프로세스부터 먼저 실행하거나 
    - 비즈니스 순서만 적절히 변경하면 예외 발생 시 보상 트랜잭션 발생 자체를 없앨 수 있거나
      - 결제 완료 -> 포인트 지급 -> 배송 준비중 이라는 프로세스가 있다고 해보자
      - 배송 준비중의 경우 상품 품절로 인한 예외가 자주 발생할 수 있다고 가정하자
      - 이런 맥락이라면 결제 완료 -> 배송 준비중 -> 포인트 지급 이라는 비즈니스 순서만 바꾸어도 배송 준비중 과정에서 예외가 발생하더라도 포인트 지급에 대한 보상 트랜잭션, 즉 포인트 회수라는 프로세스 실행은 하지 않아도 되는 로직 개선이 이루어지게 된다
  - https://docs.microsoft.com/ko-kr/azure/architecture/patterns/compensating-transaction 참고
      

</details>

# 4. 선물하기 프로젝트 개발

<details><summary> 1. Flow 설계 및 검토 </summary>

## 1. Flow 설계 및 검토

### 요구사항
- 선물하기 주문은 일반 주문과 달리, 주문 과정에서 배송지 주소를 확정할 수 없다
  - 선물하기 주문을 결제한 사람이 해당 주문을 지인하게 선물로 전달하고, 이 후 수령자가 본인의 배송지 주소를 입력해야 하는 배송이 시작되는 구조이기 때문이다
- 선물하기 결제 후 구매자와 수령자에게 카카오톡이나 LMS로 알림이 발송되어야 한다
- 수령자는 선물을 수락하거나 거절할 수 있다
- 선물하기 서비스 개발과 운영 시에는 기존 주문 서비스의 기능에는 영향이 없도록 하면서 최대한 빠르게 개발이 진행되어야 한다
- **여기에서는 실제의 복잡한 선물하기 도메인 요구사항을 간소화하여, msa에서의 서버간 통신과 비즈니스 도메인별로 서버를 나누는 내용에 초점을 맞추어 진행한다**

### 선물하기 서비스 시연
- 29CM의 선물하기 기능을 함꼐 보면서 요구사항을 파악한다

#### 선물 보내는 사람
1. 모바일 주문 화면에서 선물해보세요! 버튼을 클릭한다 
  ![image](https://user-images.githubusercontent.com/28394879/145053067-714b5759-c7d5-4941-a12e-1b97eaf37735.png)
2. 상품 상세 화면에서 선물하기를 클릭한다 
   ![image](https://user-images.githubusercontent.com/28394879/145053177-c9468e13-6199-4ea1-9a7c-566428b7b61b.png)
3. 선물 수령자와 메시지를 입력하고 결제를 완료한다
   ![image](https://user-images.githubusercontent.com/28394879/145053280-8b9eb104-d2fe-4aaa-b665-211ab7ea1a49.png)
   ![image](https://user-images.githubusercontent.com/28394879/145053346-8f92ebfe-0348-4f02-878c-88d199414d94.png)
4. 선물하기 주문 완료 화면에서 선물메시지 보내기 버튼을 클릭하여 선물 링크를 전달한다
   ![image](https://user-images.githubusercontent.com/28394879/145053468-fc747b31-057e-4f4e-8a1a-51f138281ba2.png)

#### 선물 받는 사람
1. 선물메시지 수신 화면
  ![image](https://user-images.githubusercontent.com/28394879/145053584-211db7c4-6dac-4864-92d5-e41606948087.png)
2. 선물 받을 주소지를 입력하고 선물 받기 버튼을 클릭한다 -> 선물 수령 완료
   ![image](https://user-images.githubusercontent.com/28394879/145053643-9ed1f43e-b2a6-4fa1-aa34-a437d3c90f36.png)

### 비즈니스 기능을 분리하여 도메인에 매핑하기
- msa 환경에서 새로운 기능, 또는 서비스를 개발해야 할 때에는 아래와 같은 사전 검토가 빠른 개발과 추후 운영에 큰 도움이 된다
  1. 새로운 기능, 또는 서비스의 작업을 정의해본다
  2. 정의된 작업 중에서 이미 존재하는 서비스에게 실행을 맡길 수 있는 것이 있는지 확인한다
  3. 신규 서비스에서 구현할 작업과 기존 서비스에게 맡길 작업을 나누어본다
  4. 기존 서비스에게 작업을 요청하기 위한 메시지 형태를 정의해본다
  5. 서비스간의 메시지 흐름과 처리 과정을 화이트보드 등을 이용하여 도식화해보는 것도 도움이 된다

- 위와 같은 검토 순서를 생각해 볼 때, 선물하기 주문 작업은 아래와 같은 흐름으로 설계를 진행해 볼 수 있다
  1. 선뭃라기 주문 작업은 1) 선물하기 주문 정보 등록 2) 선물하기 요청에 맞는 주문 정보 생성 3) 결제 처리 4) 선물 지급 등으로 구성된다
  2. 이 중에서 2) 주문 정보 생성과 3) 결제 처리는 기존 주문 도메인 서비스에 맡길 수 있다고 판단된다
  3. 결제 관련 작업을 제외한 모든 선물하기 작업은 선물하기 서비스에서 처리하도록 한다
  4. 이미 운영중인 주문 도메인 서비스에 결제 정보 생성과 결제 처리를 위한 메시지를 정의해야 한다
     - 일반 주문과 다르게 선물하기 주문은 결제 과정에서는 배송지 정보가 fix 되지 않기 떄문에, 기존의 일반 주문 메시지와는 약간 다른 메시지 형태를 가진다
     - 그렇기 떄문에 다음과 같은 고민이 필요하다
       - 주문 도메인 서비스에서 기존 API 를 수정하여, 선물하기 주문의 경우 배송지 정보가 입력되지 않아도 되게끔 변경하거나
       - 선물하기 서비스에서 기존 주문 생성 API를 호출할 때, 임의의 배송지 정보를 전달하거나 ( 추후 배송지 정보를 update 하게끔 처리하는 구조)
     - 각각의 장단점과 현재 서비스 상황을 고려하여 메시지 형태와 API 구현 방식을 결정한다
     - 여기에서는 
       - 선물하기 서비스에서 기존 주문 생성 API를 호출할 때, 임의의 배송지 정보를 전달하는 방식을 채택한다 (추후 배송지 정보를 update 하게끔 처리하는 구조)
         - 주문 도메인 서비스에서 주문 생성 API를 변경하여 배송지 주소를 필수 값에서 옵션 값으로 변경하면
           - 기존 도메인 서비스에서 배송지 관련 validation이 약해지고
           - 주문 도메인 서비스에서 선물하기 관련 로직을 포함하는 구조가 되어버린다
       - 채택한 방식으로 구현을 한다면
         - 기존 주문 도메인의 로직은 그대로 유지하되
         - 기존 주문 도메인에서 선물하기 주문용 신규 API를 새로 만들고
         - 이렇게 될 경우, 기존 주문 생성 도메인 로직은 유지하면서도 선물하기용 주문 생성 API를 쉽게 만들 수 있다
         - 또한 layer의 구분에 따라 domain 로직은 기존 그대로 사용 가능하고 interfaces (Controller) layer만 추가로 개발하면 된다
   5. 서버간의 전체 flow를 간략히 도식화한다
      ![image](https://user-images.githubusercontent.com/28394879/145054784-c80cd2a7-4b68-4945-b581-b5f0bfcb47a5.png)
    
### 서버간 호출 flow 및 설계 검토
- 선물하기 서비스와 주문 서비스의 위상을 생각하면, 주문 서비스가 선물하기 서비스에 비해 좀 더 보펴적이고 다른 서비스에게 기능을 제공하는 역할에 가깝다
- 그렇기 때문에 주문 서비스에서는 다른 서비스의 프로퍼티나 로직이 포함되지 않도록 지속적으로 신경쓰고 관리해야 주문 서비스를 통한 확장성이 유지될 수 있다
  - 주문 서비스의 주문 생성 API에 선물하기 서비스를 위한 추가적인 프로퍼티나 로직이 들어가게 된다면
  - 추후 주문 서비스를 활용할 다른 서비스에서 주문 생성 API를 사용하기 어렵게 된다
  - 주문 생성 API 내부에서도 if-else 나 switch-case와 같은 로직이 요청 API 형태별로 조냊할 가능성도 커진다
- 이런 배경을 생각한다면 선물하기 서비스와 줌누 서비스 간의 의존 관계는 아래와 같이 단방향을 가쪄야 한다
   ![image](https://user-images.githubusercontent.com/28394879/145055252-72693a11-c608-4639-9290-8ef1a3080038.png)
- 하지만 주문 서비스의 세부 flow를 검토하면, 선물하기 서비스와 주문 서비스 간의 단방향 의존 관계를 가지는 것이 쉽지 않음을 알 수 있다
  - 카드 결제를 포함한 일밙거인 결제의 경우, 전자지급결제대행 (Payment Gateway, PG)을 통해서 결제를 처리한다
    ![image](https://user-images.githubusercontent.com/28394879/145055402-0aaca51c-785b-4b1a-931f-48b6509121c4.png)
  - 선물하기 서비스와 주문 서비스에서 PG를 포함한 flow까지 생각하면 아래와 같은 flow를 가지게 된다
     ![image](https://user-images.githubusercontent.com/28394879/145055501-6c78a553-d354-4740-bbbb-32f3abe924a9.png)
    - 선물하기 서비스 -> 주문 서비스로 결제를 요청했지만 PG의 flow가 추가되면서 주문 서비스 -> 선물하기 서비스로의 의존 관계도 생기게 되는 것을 알 수 있다 (빨간색 5번 구간)
      - 선물하기 서비스는 2. 결제 Action 실행을 호출 후 결제 성공 응답을 받기를 원하지만, 결제 구조상 주문 서비스는 받은 요청을 PG 측으로 redirect한다(결제 모듈 loading)
      - 주문 서비스는 PG를 통한 결제 성공 후 callbackUrl이나 webHook등으로 결제 성공을 선물하기 서비스에 알려줘야 한다 (빨간색 5번 구간)
    - 추후 주문 서비스를 활용하는 서비스가 추가될 때마다 주문 서비스와의 양방향 의존 관계도 추가되는 구조가 생기게 된다
      - 양방향 관계가 추가될 때마다 도메인 로직의 전체 flow를 파악하기가 어려워진다
      - 주문 서비스가 callbackUrl 실행할 때, 이를 받아서 처리하는 서비스가 장애 상황이라면 callbackUrl 요청이 유실될 가능성도 있다 
  - 주문 서비스와 선물하기 서비스 간에 메시지 브로커를 두고 메시지 기반 비동기 통신으로 줌누 서비스 -> 선물하기 서비스의 방향성을 제거한다 
    ![image](https://user-images.githubusercontent.com/28394879/145056008-2dc43cd4-60f2-4ea2-b36c-36dd00091c25.png)
    - 주문 서비스는 결제 성공 후 메시지 브로커에 결제 성공 메시지를 발행한다
    - 선물하기 서비스는 결제 성공 메시지를 읽고 해당하는 선물하기 주문 정보를 성공으로 변경한다
    - 선물하기 서비스와 주문 서비스는 단방향 의존 관계를 유지한다
- 여기에서는 aws sqs를 활용하여 선물하기 서비스와 주문 서비스 간의 비동기 메시징 통신을 구현한다
  - 다양한 message broker가 존재하는데 aws cloud를 활용하여 서비스를 운영하는 회사가 많고
  - aws sqs의 구현과 활용이 쉬운 편이고 fifo방식의 대기열을 사용하면 메시지 발생과 수신의 순서도 보장해준다
  - **여기에서는 실제의 복잡한 선물하기 도메인 요구사항을 간소화하여, msa 에서의 서버간 통신과 비즈니스 도메인별로 서버를 나누는 내용에 초점을 맞추어 진행한다**
  - 검토된 내용을 바탕으로 한 시퀀스 다이어그램은 다음과 같다
    ![image](https://user-images.githubusercontent.com/28394879/145060255-678b6e32-e789-44ac-9760-bd0b9c086ec5.png)

    ![image](https://user-images.githubusercontent.com/28394879/145060281-f6048aef-6435-4b86-842c-009c6c832ef0.png)

    ![image](https://user-images.githubusercontent.com/28394879/145060313-5d69740b-1dfb-4feb-ac63-1fb1d088c811.png)
 

--- 

### 주문 서비스를 활용한 응용 서비스 확장
- 주문 서비스와 같이 다른 서비스의 기능 구현을 위해 기반 기능을 제공하는 서비스는 초기부터 기능 사용에 대한 확장성을 고려하여 설계하고 구현하는 것이 좋다
  - 주문 API는 최대한 보편적이고 중립적으로 구현하고 유지해야 추후 다른 서비스에서 주문 API를 활용할 때에도 문제가 되지 않는다
- 주문 서비스를 사용하는 서비스가 단 한개만 존재할 때에는 아래와 같은 구조를 가질 수 있다
  ![image](https://user-images.githubusercontent.com/28394879/145060537-011ab700-3161-4acd-bf91-d55c91a5d032.png)
  - 호출과 callbackUrl이 양쪽 서비스에서 호출되고 연결된다
    - 선물하기 서비스와 주문 서비스가 강하게 연결된다
    - 사실 callbackurl 방식은 외부에 주문 서비스 기능을 제공하는 구조에서는 가장 보편적이고 구현과 관리가 용이한 구조이다
- 비동기 메시징 구조를 통해 서버 간의 결합을 느슨하게 하고 메시지 처리에 대한 버퍼를 두고 싶다면 아래와 같은 구조를 가질 수 있다
   ![image](https://user-images.githubusercontent.com/28394879/145060716-2ce6e0ab-1df9-4faf-b4b5-a2cc91795b83.png)
   - 주문 서비스는 결제 성공 후 message broker에 성공 메시지만 발행하면, 해당 메시지를 수신할 서버가 어디인지 알 필요가 없게 된다
   - 선물하기 서버가 장애 상황이라도 추후 서비스 복구 후에 message broker의 메시지를 읽어서 주문 성공 처리를 할 수 있게 된다
- kafka의 multi consumer 구조를 활용한다면, 주문 서비스를 활용하는 클라이언트가 지속적으로 추가되어도 모든 클라이언트가 결제 성공 메시지를 전달 받을 수 있다
   ![image](https://user-images.githubusercontent.com/28394879/145060982-a4ef4a68-d8db-4acc-85fa-c5cd36317c5a.png)
   - 주문 서비스에서는 결제 성공 후 보편적인 주문 성공 메시지를 kafka에 던지고, kafka를 바라보는 클라이언트는 해당 메시지를 읽어서 각자의 결제 성공 후의 로직을 처리한다
   - 다만 메시지 내부에는 해당 주문의 클라이언트가 어디인지를 구분하는 구분값이 있어야 하고, 각 클라이언트는 자신의 메시지인지를 확인하는 필터링 로직이 추가되어야 하는 단점이 있다 
     - 예를 들어 주식 서비스에서 주문 서비스를 통해 결제 처리를 요청했고 주문 서비스가 결제 성공 메시지를 발행한다면, 해당 메시지 내부에는 serviceType="주식"과 같은 프로퍼티가 추가되어야 한다
     - kafka의 주문 성공 topic을 consuming하는 다양한 서비스들은 동일한 메시지를 수신할 것이기 떄문에 주식 서비스 이외에는 결제 성공 로직을 처리하지 않도록 필터링 로직을 구현해야 한다
   
     
     
    
    
    




</details>

<details><summary> 2. 선물하기 프로젝트 구현 </summary>

## 2. 선물하기 프로젝트 구현

### 선물하기 주요 요구사항은 다음과 같다 
- 선물하기 주문은 일반 주문과 달리, 주문 과정에서 배송지 주소를 확정할 수 없다
  - 선물하기 주문을 결제한 사람이 해당 주문을 지인하게 선물로 전달하고, 이 후 수령자가 본인의 배송지 주소를 입력해야 하는 배송이 시작되는 구조이기 때문이다
- 선물하기 결제 후 구매자와 수령자에게 카카오톡이나 LMS로 알림이 발송되어야 한다
- 수령자는 선물을 수락하거나 거절할 수 있다
- 선물하기 서비스 개발과 운영 시에는 기존 주문 서비스의 기능에는 영향이 없도록 하면서 최대한 빠르게 개발이 진행되어야 한다

선물하기 구매 flow는 다음과 같다  
![image](https://user-images.githubusercontent.com/28394879/145142801-1f5320e5-8f12-43c4-839e-7145742cec53.png)


### 해당 프로젝트 구현 시 - 필수적인 환경 셋팅
- 해당 프로젝트에서는 aws sqs 기반의 비동기 메시징 구간 개발이 있으므로 1) aws 회원 가입 2) aws sqs 생성 3) aws 내에서의 사용자 생성과 권한 부여 등이 필요하다
  - 1) aws 의 회원 가입은 관련 자료가 많고 어렵지 않으므로 여기에서는 생략하고
  - 2) aws sqs 생성과 3) aws 에서의 계정 생성 방법을 기술한다
  - 회원 가입 직후에는 일정 사용량은 무료로 이용이 가능하다 (여기 실습 과정에서는 비용 지불 없이 테스트가 가능하다고 생각한다)

**aws sqs 생성**  
- aws 로그인에 성공하면 아래와 같은 console 화면을 확인할 수 있다 
  - ![image](https://user-images.githubusercontent.com/28394879/145142972-c5f88316-8368-4d0b-938d-68728d7ca7e8.png)
- 해당 화면에서 Simple Queue Service 메뉴를 찾고 아래와 같은 화면이 나오도록 한다
  - 오른쪽 상단의 **대기열 생성** 버튼을 클릭한다 
    ![image](https://user-images.githubusercontent.com/28394879/145143034-c32c1656-da9f-4bb8-9e24-efd0a8069ee8.png)
- 해당 화면에서 FIFO를 선택하고, 해당 Queue에 대한 이름을 입력한다
  - (실습 과정이므로) 그 외 설정은 그대로 유지한다
  - 입력 후, 오른쪽 아래에서 **대기열 생성** 버튼을 클릭한다
    ![image](https://user-images.githubusercontent.com/28394879/145143103-5fb72fb2-456f-481c-9b59-59084b403985.png)
  - 아래와 같은 화면이 뜨면 실습을 위한 aws sqs 생성이 완료된 것이다
    ![image](https://user-images.githubusercontent.com/28394879/145143150-431cc28e-b8fa-48fa-8bd4-85e0772d0fe9.png)
    - 예시 코드에서는 aws sqs 의 이름을 **order-payComplete-live.fifo**로 명명했으므로 sqs 생성 시에도 동일하게 이름을 맞추면 된다

**aws 계정 생성**  
- 콘솔 홈에서 IAM 서비스를 찾아 들어가서 아래와 같은 화면이 나오도록 한다
  - 해당 화면 좌측에서 **사용자** 메뉴를 클릭한다
    ![image](https://user-images.githubusercontent.com/28394879/145143271-3912ea8f-4b53-4752-81ca-6c65d7d64d2d.png)
- 사용자 화면에서 우측 상단의 **사용자 추가** 버튼을 클릭한다
  ![image](https://user-images.githubusercontent.com/28394879/145143323-c1cff407-37fb-460d-bc4f-afdd421c9623.png)
- 사용자 이름과 엑세스 유형을 선택하고 다음 단계로 넘어간다
  - 사용자 이름은 적절하게 정한다
  - 엑세스 유형은 **프로그래밍 방식 엑세스**를 선택한다
  - 오른쪽 하단의 **다음:권한** 버튼을 클릭한다
    ![image](https://user-images.githubusercontent.com/28394879/145143395-aa0cf171-1e33-40e9-9186-c78346a51fa6.png)
- 권한 설정 화면에서 기존 정책 직접 연결 탭을 누르고 아래와 같은 화면이 나오도록 한다
  - AmazonSQSFullAccess 권한을 체크한 후
  - 오른쪽 하단의 다음:태그 버튼을 클릭한다
    ![image](https://user-images.githubusercontent.com/28394879/145143463-536ea100-bcf5-4735-b562-8d315be16430.png)
- 태그 추가 화면은 입력 없이 skip 하고 다음으로 넘어간다
   ![image](https://user-images.githubusercontent.com/28394879/145143511-2e6d7f9c-ce76-494c-a900-9752c7f1ef9a.png)
- 다음 화면 확인 후 오른쪽 하단의 **사용자 만들기** 버튼을 클릭한다
  ![image](https://user-images.githubusercontent.com/28394879/145143579-4d37ce71-ca31-447a-86bf-5e3cf843fd4f.png)
- 아래와 같은 화면이 뜨면 사용자 생성, 권한 부여가 완료된 것이다
  - 엑세스 키 ID와 비밀 엑세스 키를 복사한 후에
  - 예제 프로젝트의 application.yml 에서 cloud.aws.access-key와 cloud.aws.secret-key를 채워 넣는다
  ![image](https://user-images.githubusercontent.com/28394879/145143671-1ed45718-5a67-47fb-8788-3ee7f0cd7697.png)
- 해당 access-key 설정은 1) 주문하기 프로젝트 2) 선물하기 프로젝트 둘 다 해줘야 한다
  - 주문하기 프로젝트는 SQS에 메시지를 publish 하고
  - 선물하기 프로젝트는 SQS에서 메시지를 subscribe 한다
     
</details>

# 5. MSA 전환과 운영에 대한 tip

<details><summary> 1. MSA 전환과 운영에 대한 tip </summary>

## 1. MSA 전환과 운영에 대한 tip 

Microservice Architecture (이하 msa)를 이해하고 적용하기 위한 기술과 이론은 정말 많고 이를 모두 설명하고 전달한느 것은 한계가 있다고 생각이다.  
현재 존재하는 다양한 오픈소스와 기능만 살펴봐도
- Spring 진영에서는 Spring Cloud를 통해 msa 적용에 필요한 다양한 기능을 제공하고 있다
- 컨테이너 오케스트레이션 오픈 소스인 kubernetes (이하 k8s) 에서도 msa 적용에 필요한 다양한 기능을 동일하게 젝오한다

msa 전환과 운영에 필요한 이론적인 내용도 많다
- monolithic을 적절한 도메인으로 분리하는 전략
- 점진적인 msa 전환을 위한 다양한 기법
- 프로세스간의 다양한 통신 방법과 각각의 장단점
- 분산 트랜잭션과 사가 패턴
- API Gateway, Service Discovery 등과 같은 다양한 아키텍처와 운영 기술

여기에서는 29CM에서 모놀리틱 시스템을 msa로 전환하는 점진적인 과정과 그 안에서의 기술과 이론적인 배경을 설명하고자 한다  

msa 전환과 운영에 대한 tip은 
- msa 전환을 위한 사전 작업
- msa 전환의 과정
- msa 전환의 고도화
등으로 나누어 제공한다

</details>

<details><summary> 2. 사전 작업 </summary>

## 2. 사전 작업

### 구성원 설득하기 
- monolithic을 msa로 전환하기 위한 첫 시작은 **함께 일하는 구성원들에게 msa로 전환해야 하는 이유를 설명하고 설득하는 과정**이다
  - 이미 복잡한 monolithic 시스템을 msa로 전환하는 과정은 전사 관점에서는 많은 리소스를 투자해야 하는 기술 과업이다
  - 그렇기 때문에 msa를 전환해야 하는 사유를 다른 구성원들에게 명확하게 설명할 수 있어야 한다
- monolithic에서 msa로 전환을 검토해야 하는 시점은 다음과 같다
  - 하나의 repository에 코드베이스가 개개인이 감당할 수 없는 수준으로 커졌다
  - 이에 따라 코드 파악과 유지보수가 어려워졌다
  - 구현과 테스트, 배포의 속도가 점점 느려지고 정기배포라는 절차가 생겼다
  - 신규 기능 구현과 배포에 대한 구성원들의 부담감이 커졌다 - 배포 후 발생할 막연한 장애 가능성에 대한 두려움
  - 모든 측면에서의 확장성이 떨어지게 되었다
  - **결국 monolithic의 단점이 구각되어 비즈니스 경쟁력이 약화되고 있다는 판단이 섰을 때 msa로의 전환을 진지하게 고민해야 한다**
- 설득 시 중요 포인트
  1. msa로 전환하는 과정은 모든 사업 요소를 멈추고 전환에만 집중하는 것이 아니다
     - 기존의 비즈니스 업무를 진행하면서 점진적으로 msa전환을 진행할 수 있다
     - 기존에 없던 기능은 msa 기반의 신규 서비스에서 개발할 수도 있다. 이는 오히려 유저 경험의 향상을 가져다 준다
  2. 한번 msa로 전환하게 되면 이후에는 기존보다 좀 더 빠른 속도로 시장의 변화에 대응할 수 있게 된다
     - 비즈니스 도메인을 중심으로 시스템을 분리하게 때문에, 각 시스템을 운영하고 관리하는 각 팀마다 각자의 목표와 속도로 운영이 가능하게 된다
     - 다른 도메인 서비스와 관계없이 독립적인 배포가 가능하기 때문에, 각 도메인 별로 비즈니스 대응 속도를 향상시킬 수 있게 된다
  3. 우리보다 비즈니스 규모가 훨씬 큰 회사에서도 msa 기반으로 시스템이 운영되고 잇다
     - 이미 많은 회사에서 msa로 시스템을 운영하고 있고 monolithic에서 msa로 전환하는 검증된 사례와 방법이 많이 존재한다
     - 기업 생존의 측면에서 msa전환은 필수 사항이다. 

**29CM 사례**  
1. 20년 8월 당시의 29CM 서비스는 python + django 기반의 거대한 monolithic으로 운영되고 있었음 
   - 2020년 매출액 1,800억의 규모로 성장했고 활성 유저도 급격히 증가하였음
   - 회사의 성장을 시스템이 뒷받침하기 힘든 어려가지 신호가 발생하고 있었음
     - 배포 직후 예상치 못한 부분에서 시스템 버그가 발생할 때가 많았음
     - 테스트 해야 할 기능이 많기 때문에 2주 단위의 정기배포 절차가 존재했었음. 그렇기 때문에 빠른 기능 런칭이 이루어지지 않았음
     - 구성원들은 굵직한 feature 개발에 대한 부담감을 가지고 있었음
     - 대형 이벤트가 있을 때마다 간헐적인 시스템 장애가 발생했었음
2. monolithic의 한계 상황을 개선하기 위해 msa로의 전환을 결정하였음
   - 경졍진, 개발팀과 많은 논의를 진행하였음
   - 신규 기능 구현과 배포 속도 향상, 대량의 트래픽 처리가 가능한 시스템으로 개선 등을 근거로 msa로의 전환을 결정함
     - 빠른 비즈니스 변화에 대응 가능하도록 하기 위한 기술 기반
     - 신규 서비스 및 기능 추가, 기존 기능의 개선 과정이 모놀리틱에 비해 빠르고 수월함
     - 개별 서비스의 장애가 전체 서비스의 장애로 이루어지지 않음
     - 서비스를 담당하는 개별 팀과 구성원의 전문성이 향상됨
     - 신규 기술과 성능 개선을 적극적으로 할 수 있음
   - 기존 기능에는 영향을 주지 않으면서도 비즈니스 도메인 단위로 시스템을 작게 분리하기 위한 여러 가지 전략 등을 검토하였음
     - 스트랭글러 패턴, 점진적인 배포
     - 피쳐 플래그, 카나리 배포
     - db dual write, shared database
3. 20년 8월 이후 지금까지도 점진적인 msa 전환을 진행 중
   - 점진적인 마이그레이션을 통해 msa 전환에 대한 지식과 경험을 쌓아가고 있음
   - 그 과정에서 기존 monolithic에서는 진행하지 못했던 여러 가지 신규 기능을 런칭함
     - 상품 상세에서의 배송 예정일 노출, 구매 유저 분석에 따른 상품 추천 기능, 선물하기 서비스 등등을 런칭함

### 회사 전체 도메인의 의존관계를 그려보기
- 회사의 비즈니스 규모가 커짐에 따라 유저에게 제공하는 하나의 기능에서도 많은 도메인이 연관되어 움직이게 된다
- msa는 비즈니스 도메인을 중심으로 모델링된 각각의 서비스이기 때문에, 회사 전체의 비즈니스 도메인을 그려보는 것이 중요하다
  - 비즈니스 도메인은 현재 회사의 팀 구조를 통해서 확인할 수도 있고, 이벤트 스토밍과 같은 작업을 통해서 도출할 수도 있다
  - 코드 패키지와 데이터베이스 등을 통해서 유추할 수 있고, 유저 관점에서 서비스의 전체 흐름을 통해 확인할 수도 있다
- 코드 내에서도 모듈간의 의존관계가 존재하는 것처럼, 도메인간에도 의존관계가 존재한다. 이를 정확히 파악하는 것이 중요하다
  - 의존관계 작성 중에 도메인 간의 순환 참조가 보인다면, 도출된 도메인과 의존 관계는 잘못 그려졌을 가능성이 크다

**29CM 사례**  
- 기존 코드와 도메인, 팀 단위를 기준으로 크고 작은 도메인 서비스를 도출하였고, 각 도메인 간의 의존 관계를 도식화 하였음 **(일부 영역 생략하여 공유)**
- 처음 의존 관계를 그릴 때에는 소수의 인원이 기존 코드와 도메인 중심으로 파악했지만, 이후 많은 이들과 함께 논의하여 의존 관계를 고도화해나갔음     
  ![image](https://user-images.githubusercontent.com/28394879/145171410-3bf590fd-1e4c-490b-a793-747f891d1251.png)

### 가장 먼저 전환할 도메인을 정해보기 
- 비즈니스 도메인 중에서 가장 임펙트가 큰 것부터 전환을 시작하는 것이 좋다
  - 유저 경험, 매출과 같은 비즈니스 임펙트를 따져봤을 때, 가장 큰 도메인부터 전환을 시작해야 그 과정 가운데에서도 msa의 혜택을 누릴 수 있다
  - 반대로 말하면 임펙트가 작고 분리 안해도 되는 도메인을 굳이 전환할 필요는 없다
- 신규 기능은 msa 기반의 신규 서비스에서 개발 하는 것이 좋다
  - 어차피 msa로 전환하는 과정에서 신규 기능을 기존 monolithic에 구현할 이유는 없다
  - 다만 비즈니스 상황도 기존 코드 구조를 돌아볼 때, monolithic에서 개발하는 것이 맞다고 판단되면 신규 기능이라도 monolithic에서 개발하는 것이 맞다. 기술보다 앞서는 것은 비즈니스 목표와 상황이다
- 현재 팀의 리소스와 비즈니스 상황을 고려하여 신규 전환을 위한 리소스를 배정해야 한다
  - 비즈니스 상황이 급하고 monolithic에서 빠르게 개발이 가능한 feature라면 당연히 monolithic에서 개발이 진행되어야 한다
  - 팀 운영과 상시 업무가 가능한 상황 안에서 msa전환을 위한 리소스를 배정해야 다른 팀과 구성원들의 지지를 받으며 msa전환을 진행할 수 있다
  - 이상과 현실에 대한 균형을 놓치면 안 된다

**29CM 사례**  
- 29CM에서는 상품 도메인과 주문, 결제 도메인을 중심으로 msa전환을 시작하였음
  - 비즈니스 임펙트를 따져 봤을 때 상품과 커머스만큼 중요한 도메인은 없다고 판단함
- 전환 과정에서 유저에게 필요한 신규 기능이 구현되고 배포되었음
  - 상품의 경우, 대량 등록 기능이 구현됨
  - 커머스의 경우, 배송 예정일 / 선물하기 / 주문서 개편과 같은 신규 기능이 구현됨
  - 신규 기능과 별개로 기존 도메인 로직에 대한 msa 전환도 비교적 빠른 속도로 진행 중임
- 비즈니스 임펙트가 크고 중요한 feature가 monolithic안에서 구현하기도 함
  - 쿠폰과 배송 같은 복잡한 도메인의 경우, 기존 로직의 복잡도와 요구사항의 시급성을 고려할 때 monolithic 기반으로 작업하는 것이 맞다는 판단을 하였다
  - 한정된 리소스에서 임펙트를 최대한 얻으려면 monolithic과 msa사이의 적절한 타협이 필요함

### API 체계를 정하기
- 서버와 클라이언트 간의 API 표준과 응답 체계를 일관되게 정하는 것은 중요하다
- 서버와 클라이언트 간의 API 불일치가 존재할 경우 이를 컴파일 타임에서는 찾기 어렵기 때문에 일관되고 정확하게 정의되어야 한다
- 또한 API의 응답 체계를 기반으로 서비스 전체의 모니터링 체계를 정할 수 있기 때문에 이에 대한 시간 투자도 중요하다
  - http status를 기준으로 API 응답의 성공과 실패를 구분할 수도 있고
  - http response body의 특정 값을 기준으로 API 응답의 성공과 실패를 구분할 수도 있다
  - 어떤 체계든지 정해진 기반이 존재해야 서비스 전체의 모니터링을 진행할 수 있다 
- **3.2 partner 도메인 개발(2)의 API 응답 체계 참고**    
   
</details>

<details><summary> 3. 과정 </summary>

</details>

<details><summary> 4. 고도화 </summary>

</details>