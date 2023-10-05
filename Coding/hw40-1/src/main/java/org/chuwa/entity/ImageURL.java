package org.chuwa.entity;

public class ImageURL {
     private String title;
     private String src;
     private String alt;
     private int height;
     private int width;
     private String buttonLink;
     private String linkText;

     public String getTitle() {
          return title;
     }

     public void setTitle(String title) {
          this.title = title;
     }

     public String getSrc() {
          return src;
     }

     public void setSrc(String src) {
          this.src = src;
     }

     public String getAlt() {
          return alt;
     }

     public void setAlt(String alt) {
          this.alt = alt;
     }

     public int getHeight() {
          return height;
     }

     public void setHeight(int height) {
          this.height = height;
     }

     public int getWidth() {
          return width;
     }

     public void setWidth(int width) {
          this.width = width;
     }

     public String getButtonLink() {
          return buttonLink;
     }

     public void setButtonLink(String buttonLink) {
          this.buttonLink = buttonLink;
     }

     public String getLinkText() {
          return linkText;
     }

     public void setLinkText(String linkText) {
          this.linkText = linkText;
     }
}
