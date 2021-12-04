package dev.practice.gift.domain.gift;

import dev.practice.gift.domain.gift.GiftCommand.Register;
import dev.practice.gift.domain.gift.GiftCommand.RegisterOrderItem;
import dev.practice.gift.domain.gift.GiftCommand.RegisterOrderItemOptionGroup;
import dev.practice.gift.domain.gift.order.OrderApiCommand.Register.RegisterBuilder;
import dev.practice.gift.domain.gift.order.OrderApiCommand.RegisterOrderItem.RegisterOrderItemBuilder;
import dev.practice.gift.domain.gift.order.OrderApiCommand.RegisterOrderItemOption;
import dev.practice.gift.domain.gift.order.OrderApiCommand.RegisterOrderItemOption.RegisterOrderItemOptionBuilder;
import dev.practice.gift.domain.gift.order.OrderApiCommand.RegisterOrderItemOptionGroup.RegisterOrderItemOptionGroupBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-04T19:08:59+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Amazon.com Inc.)"
)
@Component
public class GiftToOrderMapperImpl implements GiftToOrderMapper {

    @Override
    public dev.practice.gift.domain.gift.order.OrderApiCommand.Register of(Register register) {
        if ( register == null ) {
            return null;
        }

        RegisterBuilder register1 = dev.practice.gift.domain.gift.order.OrderApiCommand.Register.builder();

        register1.buyerUserId( register.getBuyerUserId() );
        register1.payMethod( register.getPayMethod() );
        register1.orderItemList( registerOrderItemListToRegisterOrderItemList( register.getOrderItemList() ) );

        return register1.build();
    }

    @Override
    public dev.practice.gift.domain.gift.order.OrderApiCommand.RegisterOrderItem of(RegisterOrderItem register) {
        if ( register == null ) {
            return null;
        }

        RegisterOrderItemBuilder registerOrderItem = dev.practice.gift.domain.gift.order.OrderApiCommand.RegisterOrderItem.builder();

        registerOrderItem.orderCount( register.getOrderCount() );
        registerOrderItem.itemToken( register.getItemToken() );
        registerOrderItem.itemName( register.getItemName() );
        registerOrderItem.itemPrice( register.getItemPrice() );
        registerOrderItem.orderItemOptionGroupList( registerOrderItemOptionGroupListToRegisterOrderItemOptionGroupList( register.getOrderItemOptionGroupList() ) );

        return registerOrderItem.build();
    }

    @Override
    public dev.practice.gift.domain.gift.order.OrderApiCommand.RegisterOrderItemOptionGroup of(RegisterOrderItemOptionGroup register) {
        if ( register == null ) {
            return null;
        }

        RegisterOrderItemOptionGroupBuilder registerOrderItemOptionGroup = dev.practice.gift.domain.gift.order.OrderApiCommand.RegisterOrderItemOptionGroup.builder();

        registerOrderItemOptionGroup.ordering( register.getOrdering() );
        registerOrderItemOptionGroup.itemOptionGroupName( register.getItemOptionGroupName() );
        List<RegisterOrderItemOption> list = register.getOrderItemOptionList();
        if ( list != null ) {
            registerOrderItemOptionGroup.orderItemOptionList( new ArrayList<RegisterOrderItemOption>( list ) );
        }

        return registerOrderItemOptionGroup.build();
    }

    @Override
    public RegisterOrderItemOption of(dev.practice.gift.domain.gift.GiftCommand.RegisterOrderItemOption register) {
        if ( register == null ) {
            return null;
        }

        RegisterOrderItemOptionBuilder registerOrderItemOption = RegisterOrderItemOption.builder();

        registerOrderItemOption.ordering( register.getOrdering() );
        registerOrderItemOption.itemOptionName( register.getItemOptionName() );
        registerOrderItemOption.itemOptionPrice( register.getItemOptionPrice() );

        return registerOrderItemOption.build();
    }

    protected List<dev.practice.gift.domain.gift.order.OrderApiCommand.RegisterOrderItem> registerOrderItemListToRegisterOrderItemList(List<RegisterOrderItem> list) {
        if ( list == null ) {
            return null;
        }

        List<dev.practice.gift.domain.gift.order.OrderApiCommand.RegisterOrderItem> list1 = new ArrayList<dev.practice.gift.domain.gift.order.OrderApiCommand.RegisterOrderItem>( list.size() );
        for ( RegisterOrderItem registerOrderItem : list ) {
            list1.add( of( registerOrderItem ) );
        }

        return list1;
    }

    protected List<dev.practice.gift.domain.gift.order.OrderApiCommand.RegisterOrderItemOptionGroup> registerOrderItemOptionGroupListToRegisterOrderItemOptionGroupList(List<RegisterOrderItemOptionGroup> list) {
        if ( list == null ) {
            return null;
        }

        List<dev.practice.gift.domain.gift.order.OrderApiCommand.RegisterOrderItemOptionGroup> list1 = new ArrayList<dev.practice.gift.domain.gift.order.OrderApiCommand.RegisterOrderItemOptionGroup>( list.size() );
        for ( RegisterOrderItemOptionGroup registerOrderItemOptionGroup : list ) {
            list1.add( of( registerOrderItemOptionGroup ) );
        }

        return list1;
    }
}
