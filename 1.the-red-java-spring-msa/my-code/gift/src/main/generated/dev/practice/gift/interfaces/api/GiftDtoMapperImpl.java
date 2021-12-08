package dev.practice.gift.interfaces.api;

import dev.practice.gift.domain.gift.GiftCommand.Accept;
import dev.practice.gift.domain.gift.GiftCommand.Accept.AcceptBuilder;
import dev.practice.gift.domain.gift.GiftCommand.Register;
import dev.practice.gift.domain.gift.GiftCommand.Register.RegisterBuilder;
import dev.practice.gift.domain.gift.GiftCommand.RegisterOrderItem;
import dev.practice.gift.domain.gift.GiftCommand.RegisterOrderItem.RegisterOrderItemBuilder;
import dev.practice.gift.domain.gift.GiftCommand.RegisterOrderItemOption;
import dev.practice.gift.domain.gift.GiftCommand.RegisterOrderItemOption.RegisterOrderItemOptionBuilder;
import dev.practice.gift.domain.gift.GiftCommand.RegisterOrderItemOptionGroup;
import dev.practice.gift.domain.gift.GiftCommand.RegisterOrderItemOptionGroup.RegisterOrderItemOptionGroupBuilder;
import dev.practice.gift.interfaces.api.GiftDto.AcceptGiftReq;
import dev.practice.gift.interfaces.api.GiftDto.RegisterOrderItemOptionGroupReq;
import dev.practice.gift.interfaces.api.GiftDto.RegisterOrderItemOptionReq;
import dev.practice.gift.interfaces.api.GiftDto.RegisterOrderItemReq;
import dev.practice.gift.interfaces.api.GiftDto.RegisterReq;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-08T10:42:00+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class GiftDtoMapperImpl implements GiftDtoMapper {

    @Override
    public Register of(RegisterReq request) {
        if ( request == null ) {
            return null;
        }

        RegisterBuilder register = Register.builder();

        register.buyerUserId( request.getBuyerUserId() );
        register.payMethod( request.getPayMethod() );
        register.pushType( request.getPushType() );
        register.giftReceiverName( request.getGiftReceiverName() );
        register.giftReceiverPhone( request.getGiftReceiverPhone() );
        register.giftMessage( request.getGiftMessage() );
        register.orderItemList( registerOrderItemReqListToRegisterOrderItemList( request.getOrderItemList() ) );

        return register.build();
    }

    @Override
    public RegisterOrderItem of(RegisterOrderItemReq request) {
        if ( request == null ) {
            return null;
        }

        RegisterOrderItemBuilder registerOrderItem = RegisterOrderItem.builder();

        if ( request.getOrderCount() != null ) {
            registerOrderItem.orderCount( String.valueOf( request.getOrderCount() ) );
        }
        registerOrderItem.itemToken( request.getItemToken() );
        registerOrderItem.itemName( request.getItemName() );
        if ( request.getItemPrice() != null ) {
            registerOrderItem.itemPrice( String.valueOf( request.getItemPrice() ) );
        }
        registerOrderItem.orderItemOptionGroupList( registerOrderItemOptionGroupReqListToRegisterOrderItemOptionGroupList( request.getOrderItemOptionGroupList() ) );

        return registerOrderItem.build();
    }

    @Override
    public RegisterOrderItemOptionGroup of(RegisterOrderItemOptionGroupReq request) {
        if ( request == null ) {
            return null;
        }

        RegisterOrderItemOptionGroupBuilder registerOrderItemOptionGroup = RegisterOrderItemOptionGroup.builder();

        registerOrderItemOptionGroup.ordering( request.getOrdering() );
        registerOrderItemOptionGroup.itemOptionGroupName( request.getItemOptionGroupName() );
        registerOrderItemOptionGroup.orderItemOptionList( registerOrderItemOptionReqListToRegisterOrderItemOptionList( request.getOrderItemOptionList() ) );

        return registerOrderItemOptionGroup.build();
    }

    @Override
    public RegisterOrderItemOption of(RegisterOrderItemOptionReq request) {
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
    public Accept of(String giftToken, AcceptGiftReq request) {
        if ( giftToken == null && request == null ) {
            return null;
        }

        AcceptBuilder accept = Accept.builder();

        if ( giftToken != null ) {
            accept.giftToken( giftToken );
        }
        if ( request != null ) {
            accept.receiverName( request.getReceiverName() );
            accept.receiverPhone( request.getReceiverPhone() );
            accept.receiverZipcode( request.getReceiverZipcode() );
            accept.receiverAddress1( request.getReceiverAddress1() );
            accept.receiverAddress2( request.getReceiverAddress2() );
            accept.etcMessage( request.getEtcMessage() );
        }

        return accept.build();
    }

    protected List<RegisterOrderItem> registerOrderItemReqListToRegisterOrderItemList(List<RegisterOrderItemReq> list) {
        if ( list == null ) {
            return null;
        }

        List<RegisterOrderItem> list1 = new ArrayList<RegisterOrderItem>( list.size() );
        for ( RegisterOrderItemReq registerOrderItemReq : list ) {
            list1.add( of( registerOrderItemReq ) );
        }

        return list1;
    }

    protected List<RegisterOrderItemOptionGroup> registerOrderItemOptionGroupReqListToRegisterOrderItemOptionGroupList(List<RegisterOrderItemOptionGroupReq> list) {
        if ( list == null ) {
            return null;
        }

        List<RegisterOrderItemOptionGroup> list1 = new ArrayList<RegisterOrderItemOptionGroup>( list.size() );
        for ( RegisterOrderItemOptionGroupReq registerOrderItemOptionGroupReq : list ) {
            list1.add( of( registerOrderItemOptionGroupReq ) );
        }

        return list1;
    }

    protected dev.practice.gift.domain.gift.order.OrderApiCommand.RegisterOrderItemOption registerOrderItemOptionReqToRegisterOrderItemOption(RegisterOrderItemOptionReq registerOrderItemOptionReq) {
        if ( registerOrderItemOptionReq == null ) {
            return null;
        }

        dev.practice.gift.domain.gift.order.OrderApiCommand.RegisterOrderItemOption.RegisterOrderItemOptionBuilder registerOrderItemOption = dev.practice.gift.domain.gift.order.OrderApiCommand.RegisterOrderItemOption.builder();

        registerOrderItemOption.ordering( registerOrderItemOptionReq.getOrdering() );
        registerOrderItemOption.itemOptionName( registerOrderItemOptionReq.getItemOptionName() );
        registerOrderItemOption.itemOptionPrice( registerOrderItemOptionReq.getItemOptionPrice() );

        return registerOrderItemOption.build();
    }

    protected List<dev.practice.gift.domain.gift.order.OrderApiCommand.RegisterOrderItemOption> registerOrderItemOptionReqListToRegisterOrderItemOptionList(List<RegisterOrderItemOptionReq> list) {
        if ( list == null ) {
            return null;
        }

        List<dev.practice.gift.domain.gift.order.OrderApiCommand.RegisterOrderItemOption> list1 = new ArrayList<dev.practice.gift.domain.gift.order.OrderApiCommand.RegisterOrderItemOption>( list.size() );
        for ( RegisterOrderItemOptionReq registerOrderItemOptionReq : list ) {
            list1.add( registerOrderItemOptionReqToRegisterOrderItemOption( registerOrderItemOptionReq ) );
        }

        return list1;
    }
}
