package krukrad.chatBox;

//This class will assign a file name for each character. 

public class CheckForCharacters {
	
	//This function will return a string value when called.
	//This assigns each character with an Icon Image.
	//So it will show up in the text-box. :P
	
	public String CheckCharacters(char C) {
		String File = "";
        switch (C) {
            case 'a':  File = "res/Letters/UpperCases/a.png";
                     break;
            case 'b':  File = "res/Letters/UpperCases/b.png";
                     break;
            case 'c':  File = "res/Letters/UpperCases/c.png";
                     break;
            case 'd':  File = "res/Letters/UpperCases/d.png";
                     break;
            case 'e':  File = "res/Letters/UpperCases/e.png";
                     break;
            case 'f':  File = "res/Letters/UpperCases/f.png";
                     break;
            case 'g':  File = "res/Letters/UpperCases/g.png";
                     break;
            case 'h':  File = "res/Letters/UpperCases/h.png";
                     break;
            case 'i':  File = "res/Letters/UpperCases/i.png";
                     break;
            case 'j': File = "res/Letters/UpperCases/j.png";
                     break;
            case 'k': File = "res/Letters/UpperCases/k.png";
                     break;
            case 'l': File = "res/Letters/UpperCases/l.png";
                     break;
            case 'm': File = "res/Letters/UpperCases/m.png";
            		 break;
            case 'n': File = "res/Letters/UpperCases/n.png";
            		 break;
            case 'o': File = "res/Letters/UpperCases/o.png";
            		 break;
            case 'p': File = "res/Letters/UpperCases/p.png";
            		 break;
            case 'q': File = "res/Letters/UpperCases/q.png";
            		 break;
            case 'r': File = "res/Letters/UpperCases/r.png";
            		 break;
            case 's': File = "res/Letters/UpperCases/s.png";
            		 break;
            case 't': File = "res/Letters/UpperCases/t.png";
            		 break;
            case 'u': File = "res/Letters/UpperCases/u.png";
            		 break;
            case 'v': File = "res/Letters/UpperCases/v.png";
            		 break;
            case 'w': File = "res/Letters/UpperCases/w.png";
            		 break;
            case 'x': File = "res/Letters/UpperCases/x.png";
            		 break;
            case 'y': File = "res/Letters/UpperCases/y.png";
            		 break;
            case 'z': File = "res/Letters/UpperCases/z.png";
            		 break;
            case '1': File = "res/Letters/Numbers/1.png";
   		 			 break;
            case '2': File = "res/Letters/Numbers/2.png";
   		 			 break;
            case '3': File = "res/Letters/Numbers/3.png";
   		 			 break;
            case '4': File = "res/Letters/Numbers/4.png";
   		 			 break;
            case '5': File = "res/Letters/Numbers/5.png";
   		 			 break;
            case '6': File = "res/Letters/Numbers/6.png";
   		 			 break;
            case '7': File = "res/Letters/Numbers/7.png";
   		 			 break;
            case '8': File = "res/Letters/Numbers/8.png";
   		 	 		 break;
            case '9': File = "res/Letters/Numbers/9.png";
            		 break;
            case '0': File = "res/Letters/Numbers/0.png";
   		 			 break;
            case ',': File = "res/Letters/Punctuation/,.png";
   		 			 break;
            case '!': File = "res/Letters/Punctuation/EM.png";
   		 	 		 break;
            case '?': File = "res/Letters/Punctuation/QM.png";
            		 break;
            case ':': File = "res/Letters/Punctuation/SC.png";
   		 			 break;
            case '.': File = "res/Letters/Punctuation/FS.png";
   		 			 break;
            default: File = "";
                     break;
        }
		return File;
    }
}

