package com.allnewspaper.allmordernnewspaper.Model;

public class CategoriesTitle {
    int categoriesImage;
    String categoriesTitle;

    public CategoriesTitle(int categoriesImage, String categoriesTitle) {
        this.categoriesImage = categoriesImage;
        this.categoriesTitle = categoriesTitle;
    }

    public int getCategoriesImage() {
        return categoriesImage;
    }

    public void setCategoriesImage(int categoriesImage) {
        this.categoriesImage = categoriesImage;
    }

    public String getCategoriesTitle() {
        return categoriesTitle;
    }

    public void setCategoriesTitle(String categoriesTitle) {
        this.categoriesTitle = categoriesTitle;
    }
}
