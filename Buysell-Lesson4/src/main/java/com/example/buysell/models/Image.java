package com.example.buysell.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Указывает, что данный бин (класс) является сущностью
@Entity
//указывает на имя таблицы, которая будет отображаться в этой сущности
@Table(name = "images")
/*дает нам геттеры для всех полей, сеттеры для всех нефинальных полей,
правильные реализации toString, equals и hashCode, охватывающие все поля класса,
а также конструктор для всех финальных полей.*/
@Data
//будет сгенерирован конструктор с одним параметром для каждого поля вашего класса
@AllArgsConstructor
// Lombok возьмет на себя автоматическую генерацию непараметризованного конструктора
@NoArgsConstructor
public class Image {
    @Id
    // указывает, что данное свойство будет создаваться согласно указанной стратегии
    @GeneratedValue(strategy = GenerationType.AUTO)
    // указывает на имя колонки, которая отображается в свойство сущности
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "originalFileName")
    private String originalFileName;
    @Column(name = "size")
    private Long size;
    @Column(name = "contentType")
    private String contentType;
    @Column(name = "isPreviewImage")
    private boolean isPreviewImage;
    // указание на большие объекты
    @Lob
    private byte[] bytes;
    //указывает на связь многие к одному
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Product product;
}
