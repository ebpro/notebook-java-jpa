package fr.univtln.bruno.demos.jpa.orders;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CATALOG_ITEM")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NamedQuery(name = "CatalogItem.findAll", query = "select ci from CatalogItem ci")
public class CatalogItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catitem_seq")
    @EqualsAndHashCode.Include
    private long id;

    private String name;

    @Basic(fetch = FetchType.LAZY)
    private String description;

    private float unitPrice;
}
