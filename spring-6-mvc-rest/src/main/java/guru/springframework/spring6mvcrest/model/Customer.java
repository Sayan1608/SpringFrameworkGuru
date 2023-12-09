package guru.springframework.spring6mvcrest.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class Customer {
    private UUID id;
    private String customerName;
    private String version;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;
}
