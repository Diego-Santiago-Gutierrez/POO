public class Conversiones{
    
    public int hexToDec(String numberString) throws Exception, NegativeValueEnteredException, InvalidHexException{
        
        if(numberString.contains("-"))
            throw new NegativeValueEnteredException();

        if(numberString.contains("0X"))
            numberString = numberString.substring(2);
    
        else {    
            if(Character.isDigit(numberString.charAt(0)))
            throw new Exception("EL FORMATO NO CORRESPONDE A UN NUMERO DECIMAL"); 
        throw new Exception("EL FORMATO NO CORRESPONDE A UN NUMERO");
        }

        try{
            int decimalNumber = Integer.parseInt(numberString, 16);
            return decimalNumber;
        } catch(NumberFormatException e){
            throw new InvalidHexException();
        }

    }

    public String decToHex(int numberInt) throws NegativeValueEnteredException{
        if(numberInt<0)
            throw new NegativeValueEnteredException();            
        String hexNumber = "0X"+Integer.toHexString(numberInt).toUpperCase();
        return hexNumber;            
    }
}