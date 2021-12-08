package dev.practice.order.interfaces.item;

import dev.practice.order.domain.item.ItemCommand.RegisterItemOptionGroupRequest.RegisterItemOptionGroupRequestBuilder;
import dev.practice.order.domain.item.ItemCommand.RegisterItemOptionRequest;
import dev.practice.order.domain.item.ItemCommand.RegisterItemOptionRequest.RegisterItemOptionRequestBuilder;
import dev.practice.order.domain.item.ItemCommand.RegisterItemRequest;
import dev.practice.order.domain.item.ItemCommand.RegisterItemRequest.RegisterItemRequestBuilder;
import dev.practice.order.domain.item.ItemInfo.Main;
import dev.practice.order.interfaces.item.ItemDto.ItemOptionGroupInfo;
import dev.practice.order.interfaces.item.ItemDto.ItemOptionGroupInfo.ItemOptionGroupInfoBuilder;
import dev.practice.order.interfaces.item.ItemDto.ItemOptionInfo;
import dev.practice.order.interfaces.item.ItemDto.ItemOptionInfo.ItemOptionInfoBuilder;
import dev.practice.order.interfaces.item.ItemDto.Main.MainBuilder;
import dev.practice.order.interfaces.item.ItemDto.RegisterItemOptionGroupRequest;
import dev.practice.order.interfaces.item.ItemDto.RegisterResponse;
import dev.practice.order.interfaces.item.ItemDto.RegisterResponse.RegisterResponseBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-08T10:51:04+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Amazon.com Inc.)"
)
@Component
public class ItemDtoMapperImpl implements ItemDtoMapper {

    @Override
    public RegisterItemRequest of(dev.practice.order.interfaces.item.ItemDto.RegisterItemRequest request) {
        if ( request == null ) {
            return null;
        }

        RegisterItemRequestBuilder registerItemRequest = RegisterItemRequest.builder();

        registerItemRequest.itemOptionGroupRequestList( registerItemOptionGroupRequestListToRegisterItemOptionGroupRequestList( request.getItemOptionGroupList() ) );
        registerItemRequest.itemName( request.getItemName() );
        registerItemRequest.itemPrice( request.getItemPrice() );

        return registerItemRequest.build();
    }

    @Override
    public dev.practice.order.domain.item.ItemCommand.RegisterItemOptionGroupRequest of(RegisterItemOptionGroupRequest request) {
        if ( request == null ) {
            return null;
        }

        RegisterItemOptionGroupRequestBuilder registerItemOptionGroupRequest = dev.practice.order.domain.item.ItemCommand.RegisterItemOptionGroupRequest.builder();

        registerItemOptionGroupRequest.itemOptionRequestList( registerItemOptionRequestListToRegisterItemOptionRequestList( request.getItemOptionList() ) );
        registerItemOptionGroupRequest.ordering( request.getOrdering() );
        registerItemOptionGroupRequest.itemOptionGroupName( request.getItemOptionGroupName() );

        return registerItemOptionGroupRequest.build();
    }

    @Override
    public RegisterItemOptionRequest of(dev.practice.order.interfaces.item.ItemDto.RegisterItemOptionRequest request) {
        if ( request == null ) {
            return null;
        }

        RegisterItemOptionRequestBuilder registerItemOptionRequest = RegisterItemOptionRequest.builder();

        registerItemOptionRequest.ordering( request.getOrdering() );
        registerItemOptionRequest.itemOptionName( request.getItemOptionName() );
        registerItemOptionRequest.itemOptionPrice( request.getItemOptionPrice() );

        return registerItemOptionRequest.build();
    }

    @Override
    public RegisterResponse of(String itemToken) {
        if ( itemToken == null ) {
            return null;
        }

        RegisterResponseBuilder registerResponse = RegisterResponse.builder();

        registerResponse.itemToken( itemToken );

        return registerResponse.build();
    }

    @Override
    public dev.practice.order.interfaces.item.ItemDto.Main of(Main main) {
        if ( main == null ) {
            return null;
        }

        MainBuilder main1 = dev.practice.order.interfaces.item.ItemDto.Main.builder();

        main1.itemToken( main.getItemToken() );
        main1.partnerId( main.getPartnerId() );
        main1.itemName( main.getItemName() );
        main1.itemPrice( main.getItemPrice() );
        main1.status( main.getStatus() );
        main1.itemOptionGroupList( itemOptionGroupInfoListToItemOptionGroupInfoList( main.getItemOptionGroupList() ) );

        return main1.build();
    }

    @Override
    public ItemOptionGroupInfo of(dev.practice.order.domain.item.ItemInfo.ItemOptionGroupInfo itemOptionGroup) {
        if ( itemOptionGroup == null ) {
            return null;
        }

        ItemOptionGroupInfoBuilder itemOptionGroupInfo = ItemOptionGroupInfo.builder();

        itemOptionGroupInfo.ordering( itemOptionGroup.getOrdering() );
        itemOptionGroupInfo.itemOptionGroupName( itemOptionGroup.getItemOptionGroupName() );
        itemOptionGroupInfo.itemOptionList( itemOptionInfoListToItemOptionInfoList( itemOptionGroup.getItemOptionList() ) );

        return itemOptionGroupInfo.build();
    }

    @Override
    public ItemOptionInfo of(dev.practice.order.domain.item.ItemInfo.ItemOptionInfo itemOption) {
        if ( itemOption == null ) {
            return null;
        }

        ItemOptionInfoBuilder itemOptionInfo = ItemOptionInfo.builder();

        itemOptionInfo.ordering( itemOption.getOrdering() );
        itemOptionInfo.itemOptionName( itemOption.getItemOptionName() );
        itemOptionInfo.itemOptionPrice( itemOption.getItemOptionPrice() );

        return itemOptionInfo.build();
    }

    protected List<dev.practice.order.domain.item.ItemCommand.RegisterItemOptionGroupRequest> registerItemOptionGroupRequestListToRegisterItemOptionGroupRequestList(List<RegisterItemOptionGroupRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<dev.practice.order.domain.item.ItemCommand.RegisterItemOptionGroupRequest> list1 = new ArrayList<dev.practice.order.domain.item.ItemCommand.RegisterItemOptionGroupRequest>( list.size() );
        for ( RegisterItemOptionGroupRequest registerItemOptionGroupRequest : list ) {
            list1.add( of( registerItemOptionGroupRequest ) );
        }

        return list1;
    }

    protected List<RegisterItemOptionRequest> registerItemOptionRequestListToRegisterItemOptionRequestList(List<dev.practice.order.interfaces.item.ItemDto.RegisterItemOptionRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<RegisterItemOptionRequest> list1 = new ArrayList<RegisterItemOptionRequest>( list.size() );
        for ( dev.practice.order.interfaces.item.ItemDto.RegisterItemOptionRequest registerItemOptionRequest : list ) {
            list1.add( of( registerItemOptionRequest ) );
        }

        return list1;
    }

    protected List<ItemOptionGroupInfo> itemOptionGroupInfoListToItemOptionGroupInfoList(List<dev.practice.order.domain.item.ItemInfo.ItemOptionGroupInfo> list) {
        if ( list == null ) {
            return null;
        }

        List<ItemOptionGroupInfo> list1 = new ArrayList<ItemOptionGroupInfo>( list.size() );
        for ( dev.practice.order.domain.item.ItemInfo.ItemOptionGroupInfo itemOptionGroupInfo : list ) {
            list1.add( of( itemOptionGroupInfo ) );
        }

        return list1;
    }

    protected List<ItemOptionInfo> itemOptionInfoListToItemOptionInfoList(List<dev.practice.order.domain.item.ItemInfo.ItemOptionInfo> list) {
        if ( list == null ) {
            return null;
        }

        List<ItemOptionInfo> list1 = new ArrayList<ItemOptionInfo>( list.size() );
        for ( dev.practice.order.domain.item.ItemInfo.ItemOptionInfo itemOptionInfo : list ) {
            list1.add( of( itemOptionInfo ) );
        }

        return list1;
    }
}
