package nl.strohalm.cyclos.entities.members.messages;

import nl.strohalm.cyclos.entities.converters.StringValuedEnumAttributeConverter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class MessageDirectionAttributeConverter extends StringValuedEnumAttributeConverter<Message.Direction> implements AttributeConverter<Message.Direction, String> {
}
