package org.example.deploy101.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

/**
 * @author Vladimir Solovyov
 * @project deploy101
 * @date on 23/08/2024
 */

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
public class FileMetadata {
    UUID fileId;
    String fileName;
    int fileSize;
}
