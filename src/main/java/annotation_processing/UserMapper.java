package annotation_processing;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * 1. Demo delegating to Javac to handle annotation processing
 *    - Check the generated source file at target\generated-sources\annotations\annotation_processing\UserMapperImpl.java,
 * which contains the compiler info used for annotation processing.
 * 
 * 2. Demo the incremental builder support for annotation processing
 *    - Update the property "email" of UserDto to "new_email"
 *    - Update source property "new_email" of UserMapper#fromRecord to "new_email"
 *    - Check if the generated source file at target\generated-sources\annotations\annotation_processing\UserMapperImpl.java
 *      to be refreshed.
 */
@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "mail", source = "new_email")
    UserEntity fromRecord(UserDto record);

    @InheritInverseConfiguration
    UserDto toRecord(UserEntity entity);
}
