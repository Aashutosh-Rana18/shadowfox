public class Calculator 
{
        public static void main(String []args)
        {
            double result=0.0;
            try
            {
                switch(args[1])
                {
                    case "+":
                    {
                        result=Double.parseDouble(args[0])+Double.parseDouble(args[2]);
                        break;
                    }
                    case "-":
                    {
                        result=Double.parseDouble(args[0])-Double.parseDouble(args[2]);
                        break;
                    }
                    case "*":
                    {
                        result=Double.parseDouble(args[0])*Double.parseDouble(args[2]);
                        break;
                    }
                    case "/":
                    {
                        if (Double.parseDouble(args[2])==0) 
                        {
                            System.out.println("Second input can't be zero");
                            result = 0;
                        } 
                        else 
                        {
                            result=Double.parseDouble(args[0])/Double.parseDouble(args[2]);
                        }
                        break;
                    }
                    case "sqrt":
                    {
                        result=Math.sqrt(Double.parseDouble(args[0]));
                        break;
                    }
                    case "pow":
                    {
                        result=Math.pow(Double.parseDouble(args[0]),Double.parseDouble(args[2]));
                        break;
                    }
                    case "ctof":
                        result=(Double.parseDouble(args[0])*9/5)+32;
                        break;

                    case "ftoc":
                        result=(Double.parseDouble(args[0])-32)*5/9;
                        break;
                
                default:
                    System.out.println("Invalid operation");
                    return;
                }
            } 
        catch (NumberFormatException e) 
        {
            System.out.println("Invalid number format");
        } 
        catch (ArrayIndexOutOfBoundsException e) 
        {
            System.out.println("Missing arguments");
        }
            System.out.print("Result : "+result);
        }
    }
