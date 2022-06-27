package com.toy.shop.domain.item;

import com.toy.shop.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

import static com.toy.shop.code.DBLength.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(length = NAME_LENGTH, nullable = false)
    @Comment("카테고리명")
    private String categoryNm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    @Comment("상위 카테고리 ID")
    private Category category;

    @Comment("레벨")
    private Integer level;

    @Comment("순서")
    private Integer sort;

    //==================  생성 메서드  ==================//
    public static Category newRoot(String categoryNm, Integer sort) {
        Category root = new Category();
        root.categoryNm = categoryNm;
        root.level = 1;
        root.sort = sort;

        return root;
    }

    public static Category newLeaf(String categoryNm, Category parent, Integer sort) {
        Category leaf = new Category();
        leaf.category = parent;
        leaf.categoryNm = categoryNm;
        leaf.level = parent.getLevel() + 1;
        leaf.sort = sort;

        return leaf;
    }
}
