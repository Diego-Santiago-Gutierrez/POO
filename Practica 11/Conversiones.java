public class Conversiones{
    
    public int hexToDec(String number) throws Exception, NegativeValueEnteredException, InvalidHexException{
        
        if(number.contains("-"))
            throw new NegativeValueEnteredException();

        if(number.contains("0X") || number.contains("0x"))
            number = number.substring(2);

        try{
            int dec = Integer.parseInt(number, 16); //Number is a string. 16 is the way that we express an hexadecimal number 
            return dec;
        } catch(NumberFormatException e){
            throw new InvalidHexException();
        }

    }

    public String decToHex(int number) throws NegativeValueEnteredException{
        if(number<0)
            throw new NegativeValueEnteredException();            
        String hex = "0X"+Integer.toHexString(number).toUpperCase(); //toHexString(number) lo vuelve hexadecimal
        return hex;            
    }
}