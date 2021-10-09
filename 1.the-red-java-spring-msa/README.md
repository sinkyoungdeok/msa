
# 1. 개요

<details> <summary> 1. intro </summary>

## 1. intro

- 서비스의 인수인계 과정에서도 코드와 함께 개발 디자인 문서를 전달한다면, 넘겨 받는 동료가 해당 서비스에 대한 구조 파악을 비교적 빠르게 진행할 수 있다

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

# 2. 프로젝트 구조 및 설계

# 3. 주문 프로젝트 개발

# 4. 선물하기 프로젝트 개발

# 5. MSA 전환과 운영에 대한 tip