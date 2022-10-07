package hello.core.Order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;
    @BeforeEach
    public void beforEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
    @Test
    void createOrder(){
        Long memberID = 1L;
        Member member = new Member(memberID, "memberA", Grade.VIP);
        memberService.join(member);

        Order od = orderService.createOrder(memberID, "itemA", 10000);
        Assertions.assertThat(od.getDiscountPrice()).isEqualTo(1000);
    }
}
