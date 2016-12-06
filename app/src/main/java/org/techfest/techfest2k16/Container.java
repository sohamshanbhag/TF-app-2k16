package org.techfest.techfest2k16;

/**
 * Created by sunny on 04/12/16.
 */

public class Container {
    String title;
    String subtitle1;
    String subtitle2;
    int image1;
    int image2;

    public Container(String title,String subtitle1,String subtitle2,int image1,int image2)
    {
        this.title=title;
        this.subtitle1=subtitle1;
        this.subtitle2=subtitle2;
        this.image1=image1;
        this.image2=image2;

    }
    public String getTitle()
    {
        return title;
    }
    public String getSubtitle1()
    {
        return subtitle1;
    }
    public String getSubtitle2()
    {
        return subtitle2;
    }
    public int getImage1()
    {
        return image1;
    }
    public int getImage2()
    {
        return image2;
    }

}
