package patterns.creational.FactoryMethod;

public class AbstractFactory {
 public static void main(String[] args) {
WatchMaker maker= Auxiliary.createByName("Roman");
Watch watch= maker.createWatch();
watch.showTime();
 }


}

interface Watch{
public void showTime();
}

interface  WatchMaker{
 public Watch createWatch();
}

class DigitalWatch implements Watch{

 @Override
 public void showTime() {
  System.out.println("Digital time");
 }
}

class RomanWatch implements Watch{

 @Override
 public void showTime() {
  System.out.println("Roman time");
 }
}

class CreateDigital implements WatchMaker{
 @Override
 public Watch createWatch() {
return new DigitalWatch();
 }
}

class CreateRoman implements WatchMaker{

 @Override
 public Watch createWatch() {
  return new RomanWatch();
 }
}

class Auxiliary{
  public static WatchMaker createByName(String name) {
   if (name == "Digital") return new CreateDigital();
   else return new CreateRoman();
  }
}