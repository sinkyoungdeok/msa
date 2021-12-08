package dev.practice.order.interfaces.partner;

import dev.practice.order.domain.partner.PartnerCommand;
import dev.practice.order.domain.partner.PartnerCommand.PartnerCommandBuilder;
import dev.practice.order.interfaces.partner.PartnerDto.RegisterRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-08T11:18:28+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Amazon.com Inc.)"
)
@Component
public class PartnerDtoMapperImpl implements PartnerDtoMapper {

    @Override
    public PartnerCommand of(RegisterRequest request) {
        if ( request == null ) {
            return null;
        }

        PartnerCommandBuilder partnerCommand = PartnerCommand.builder();

        partnerCommand.partnerName( request.getPartnerName() );
        partnerCommand.businessNo( request.getBusinessNo() );
        partnerCommand.email( request.getEmail() );

        return partnerCommand.build();
    }
}
