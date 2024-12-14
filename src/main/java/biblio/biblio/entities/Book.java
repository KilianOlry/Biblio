package biblio.biblio.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "synopsis", columnDefinition = "TEXT", nullable = false)
    private String synopsis;
}
