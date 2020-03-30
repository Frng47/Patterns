package patterns.structural.adapter;

public class AdapterApp {
    public static void main(String[] args) {
        Adapter adapter=new Adapter();
        adapter.drawRasterSquare();
        adapter.drawRasterLine();
        //second way
Adapter2 adapter2=new Adapter2();
adapter2.drawLine();
adapter2.drawSquare();
    }

}
interface Graphic{
    void drawLine();
    void drawSquare();
}

class RasterGraphic{
    void drawRasterLine(){
        System.out.println("raster line");
    }
    void drawRasterSquare(){
        System.out.println("raster square");
    }
}
class Adapter extends RasterGraphic implements Graphic{

    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
drawRasterSquare();
    }
}

class Adapter2  implements Graphic{
    RasterGraphic raster=new RasterGraphic();
    @Override
    public void drawLine() {
raster.drawRasterLine();
    }

    @Override
    public void drawSquare() {
raster.drawRasterSquare();
    }
}