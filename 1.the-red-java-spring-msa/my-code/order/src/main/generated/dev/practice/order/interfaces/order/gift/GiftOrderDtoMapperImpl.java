package dev.practice.order.interfaces.order.gift;

import dev.practice.order.domain.order.OrderCommand.PaymentRequest.PaymentRequestBuilder;
import dev.practice.order.domain.order.OrderCommand.RegisterOrder;
import dev.practice.order.domain.order.OrderCommand.RegisterOrder.RegisterOrderBuilder;
import dev.practice.order.domain.order.OrderCommand.RegisterOrderItem;
import dev.practice.order.domain.order.OrderCommand.RegisterOrderItem.RegisterOrderItemBuilder;
import dev.practice.order.domain.order.OrderCommand.RegisterOrderItemOption;
import dev.practice.order.domain.order.OrderCommand.RegisterOrderItemOption.RegisterOrderItemOptionBuilder;
import dev.practice.order.domain.order.OrderCommand.RegisterOrderItemOptionGroup;
import dev.practice.order.domain.order.OrderCommand.RegisterOrderItemOptionGroup.RegisterOrderItemOptionGroupBuilder;
import dev.practice.order.interfaces.order.gift.GiftOrderDto.PaymentRequest;
import dev.practice.order.interfaces.order.gift.GiftOrderDto.RegisterOrderItemOptionGroupRequest;
import dev.practice.order.interfaces.order.gift.GiftOrderDto.RegisterOrderItemOptionRequest;
import dev.practice.order.interfaces.order.gift.GiftOrderDto.RegisterOrderRequest;
import dev.practice.order.interfaces.order.gift.GiftOrderDto.RegisterResponse;
import dev.practice.order.interfaces.order.gift.GiftOrderDto.RegisterResponse.RegisterResponseBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-08T10:51:03+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Amazon.com Inc.)"
)
@Component
public class GiftOrderDtoMapperImpl implements GiftOrderDtoMapper {

    @Override
    public RegisterOrder of(RegisterOrderRequest request) {
        if ( request == null ) {
            return null;
        }

        RegisterOrderBuilder registerOrder = RegisterOrder.builder();

        registerOrder.userId( request.getBuyerUserId() );
        registerOrder.payMethod( request.getPayMethod() );
        registerOrder.receiverName( request.getReceiverName() );
        registerOrder.receiverPhone( request.getReceiverPhone() );
        registerOrder.receiverZipcode( request.getReceiverZipcode() );
        registerOrder.receiverAddress1( request.getReceiverAddress1() );
        registerOrder.receiverAddress2( request.getReceiverAddress2() );
        registerOrder.etcMessage( request.getEtcMessage() );
        registerOrder.orderItemList( registerOrderItemListToRegisterOrderItemList( request.getOrderItemList() ) );

        return registerOrder.build();
    }

    @Override
    public RegisterOrderItem of(dev.practice.order.interfaces.order.gift.GiftOrderDto.RegisterOrderItem request) {
        if ( request == null ) {
            return null;
        }

        RegisterOrderItemBuilder registerOrderItem = RegisterOrderItem.builder();

        registerOrderItem.orderCount( request.getOrderCount() );
        registerOrderItem.itemToken( request.getItemToken() );
        registerOrderItem.itemName( request.getItemName() );
        registerOrderItem.itemPrice( request.getItemPrice() );
        registerOrderItem.orderItemOptionGroupList( registerOrderItemOptionGroupRequestListToRegisterOrderItemOptionGroupList( request.getOrderItemOptionGroupList() ) );

        return registerOrderItem.build();
    }

    @Override
    public RegisterOrderItemOptionGroup of(RegisterOrderItemOptionGroupRequest request) {
        if ( request == null ) {
            return null;
        }

        RegisterOrderItemOptionGroupBuilder registerOrderItemOptionGroup = RegisterOrderItemOptionGroup.builder();

        registerOrderItemOptionGroup.ordering( request.getOrdering() );
        registerOrderItemOptionGroup.itemOptionGroupName( request.getItemOptionGroupName() );
        registerOrderItemOptionGroup.orderItemOptionList( registerOrderItemOptionRequestListToRegisterOrderItemOptionList( request.getOrderItemOptionList() ) );

        return registerOrderItemOptionGroup.build();
    }

    @Override
    public RegisterOrderItemOption of(RegisterOrderItemOptionRequest request) {
        if ( request == null ) {
            return null;
        }

        RegisterOrderItemOptionBuilder registerOrderItemOption = RegisterOrderItemOption.builder();

        registerOrderItemOption.ordering( request.getOrdering() );
        registerOrderItemOption.itemOptionName( request.getItemOptionName() );
        registerOrderItemOption.itemOptionPrice( request.getItemOptionPrice() );

        return registerOrderItemOption.build();
    }

    @Override
    public RegisterResponse of(String orderToken) {
        if ( orderToken == null ) {
            return null;
        }

        RegisterResponseBuilder registerResponse = RegisterResponse.builder();

        registerResponse.orderToken( orderToken );

        return registerResponse.build();
    }

    @Override
    public dev.practice.order.domain.order.OrderCommand.PaymentRequest of(PaymentRequest request) {
        if ( request == null ) {
            return null;
        }

        PaymentRequestBuilder paymentRequest = dev.practice.order.domain.order.OrderCommand.PaymentRequest.builder();

        paymentRequest.orderToken( request.getOrderToken() );
        paymentRequest.amount( request.getAmount() );
        paymentRequest.payMethod( request.getPayMethod() );

        return paymentRequest.build();
    }

    protected List<RegisterOrderItem> registerOrderItemListToRegisterOrderItemList(List<dev.practice.order.interfaces.order.gift.GiftOrderDto.RegisterOrderItem> list) {
        if ( list == null ) {
            return null;
        }

        List<RegisterOrderItem> list1 = new ArrayList<RegisterOrderItem>( list.size() );
        for ( dev.practice.order.interfaces.order.gift.GiftOrderDto.RegisterOrderItem registerOrderItem : list ) {
            list1.add( of( registerOrderItem ) );
        }

        return list1;
    }

    protected List<RegisterOrderItemOptionGroup> registerOrderItemOptionGroupRequestListToRegisterOrderItemOptionGroupList(List<RegisterOrderItemOptionGroupRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<RegisterOrderItemOptionGroup> list1 = new ArrayList<RegisterOrderItemOptionGroup>( list.size() );
        for ( RegisterOrderItemOptionGroupRequest registerOrderItemOptionGroupRequest : list ) {
            list1.add( of( registerOrderItemOptionGroupRequest ) );
        }

        return list1;
    }

    protected List<RegisterOrderItemOption> registerOrderItemOptionRequestListToRegisterOrderItemOptionList(List<RegisterOrderItemOptionRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<RegisterOrderItemOption> list1 = new ArrayList<RegisterOrderItemOption>( list.size() );
        for ( RegisterOrderItemOptionRequest registerOrderItemOptionRequest : list ) {
            list1.add( of( registerOrderItemOptionRequest ) );
        }

        return list1;
    }
}
