/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cs359db.db.*;
import cs359db.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author panos
 */
@WebServlet(name="MyServlet", urlPatterns = {"/MyServlet"})
public class MyServlet extends HttpServlet {
Random rand = new Random();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
       List<User> A=new ArrayList<>();
       List<User> loggedIn=new ArrayList<>();
        ArrayList<Cookie> myCookies=new ArrayList<>();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        String fname;
        fname = request.getParameter("function");
        Cookie[] requestCookies = request.getCookies();
       A=UserDB.getUsers();
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if("signup".equals(fname)){
                int found3=0;
                 if(requestCookies==null){
                Cookie sessionCookie=new Cookie("mySessionCookie",""+rand.nextInt());
                response.addCookie(sessionCookie);
                myCookies.add(sessionCookie);
            }
               
                   
                            if(!loggedIn.isEmpty()){
                                found3=1;
                                out.println("Another user is logged in, please sign him out and try again!<br>");
                                
                                out.println(" <input class='button' id='but4' type='button' value=\"Sign Out\" onclick='signOut();'  >");
                                out.println("<input class='button' id='but1' type='button' value=\"Sign up\" onclick='sendAjaxGet();'>");
                           }
            
            if(found3==0){
                
            
            out.println("<label for='uname'>*Όνομα Χρήστη:</label>");
            out.println("<input id='uname' type='text' name='username' onchange='validateUsername(this.value);' >");
            out.println("<nav style='font-size:12px;'>Tουλάχιστον 8 χαρακτήρες</nav><br>");
            out.println("<label for='email'>*Email:</label> ");
            out.println("<input id='email' type='email' name='email' onchange='validateEmail(this.value);' ><br>");
            out.println("<label for='password'>*Κωδικός:</label>");
            out.println("<input id='password' type='password' name='password' onchange='validatePassword(this.value);' >");
            out.println("<nav style='font-size:12px;'>Κωδικός Χρήστη, απο 6 εως 10 χαρακτήρες, περιέχει τουλάχιστον ένα λατινικό γραμμα,έναν αριθμό και ένα σύμβολο(#,$,%,!)</nav><br>");
            out.println("<label for='vpassword'>*Επιβεβαίωση Κωδικού:</label>");
            out.println("<input id='vpassword' type='password' name='vpassword' onchange='validateVpassword(this.value);' >");
                 out.println("<nav style='font-size:12px;'>Επιβεβαίωση Κωδικού Χρήστη</nav><br>");
            out.println("<label for='firstname'>*Όνομα:</label>");
            out.println("<input id='firstname' type='text' name='firstname' onchange='validateFname(this.value);' >");
            out.println("<nav style='font-size:12px;'>Aπο 3 εως 20 χαρακτήρες</nav><br>");
            out.println("<label for='lastname'>*Επώνυμο:</label>");
            out.println("<input id='lastname' type='text' name='lastname' onchange='validateLname(this.value);' >");
            out.println("<nav style='font-size:12px;'>Aπο 4 εως 20 χαρακτήρες</nav><br>");
            out.println("<label for='dob'>*Ημερομηνία Γέννησης:</label>");
            out.println("<input id='dob' type='date' name='dob' max='2001-11-16' >");
            out.println("<nav style='font-size:12px;'>Η εγγραφή επιτρέπεται σε άτομα μεγαλύτερα των 15 ετών</nav><br>");
            out.println("<label for='gender'>Φύλο:</label>");
           out.println("<form>"); 
           out.println("<input id='gender'  type=\"radio\" name=\"gender\" value=\"male\" >Άνδρας");     
           out.println("<input id='gender1' type=\"radio\" name=\"gender\" value=\"female\">Γυναίκα");     
           out.println("<input id='gender2' type=\"radio\" name=\"gender\" value=\"other\">Άλλο<br><br>");    
           out.println("</form> ");      
            out.println("<label for='country'>*Χώρα:</label>");
            out.println("<select id='country' name='country' >");
            out.println("<option value=\"GR\">Greece</option>" +
                        "<option value=\"AF\">Afghanistan</option>" +
                        "<option value=\"AX\">Åland Islands</option>" +
                    "<option value=\"AL\">Albania</option>\n" +
                    "	<option value=\"DZ\">Algeria</option>\n" +
                    "	<option value=\"AS\">American Samoa</option>\n" +
                    "	<option value=\"AD\">Andorra</option>" +
                                        "<option value=\"AO\">Angola</option>\n" +
                    "	<option value=\"AI\">Anguilla</option>\n" +
                    "	<option value=\"AQ\">Antarctica</option>\n" +
                    "	<option value=\"AG\">Antigua and Barbuda</option>\n" +
                    "	<option value=\"AR\">Argentina</option>\n" +
                    "	<option value=\"AM\">Armenia</option>\n" +
                    "	<option value=\"AW\">Aruba</option>\n" +
                    "	<option value=\"AU\">Australia</option>\n" +
                    "	<option value=\"AT\">Austria</option>\n" +
                    "	<option value=\"AZ\">Azerbaijan</option>\n" +
                    "	<option value=\"BS\">Bahamas</option>\n" +
                    "	<option value=\"BH\">Bahrain</option>\n" +
                    "	<option value=\"BD\">Bangladesh</option>\n" +
                    "	<option value=\"BB\">Barbados</option>\n" +
                    "	<option value=\"BY\">Belarus</option>\n" +
                    "	<option value=\"BE\">Belgium</option>\n" +
                    "	<option value=\"BZ\">Belize</option>\n" +
                    "	<option value=\"BJ\">Benin</option>\n" +
                    "	<option value=\"BM\">Bermuda</option>\n" +
                    "	<option value=\"BT\">Bhutan</option>\n" +
                    "	<option value=\"BO\">Bolivia, Plurinational State of</option>\n" +
                    "	<option value=\"BQ\">Bonaire, Sint Eustatius and Saba</option>\n" +
                    "	<option value=\"BA\">Bosnia and Herzegovina</option>\n" +
                    "	<option value=\"BW\">Botswana</option>\n" +
                    "	<option value=\"BV\">Bouvet Island</option>\n" +
                    "	<option value=\"BR\">Brazil</option>\n" +
                    "	<option value=\"IO\">British Indian Ocean Territory</option>\n" +
                    "	<option value=\"BN\">Brunei Darussalam</option>\n" +
                    "	<option value=\"BG\">Bulgaria</option>\n" +
                    "	<option value=\"BF\">Burkina Faso</option>\n" +
                    "	<option value=\"BI\">Burundi</option>\n" +
                    "	<option value=\"KH\">Cambodia</option>\n" +
                    "	<option value=\"CM\">Cameroon</option>\n" +
                    "	<option value=\"CA\">Canada</option>\n" +
                    "	<option value=\"CV\">Cape Verde</option>\n" +
                    "	<option value=\"KY\">Cayman Islands</option>\n" +
                    "	<option value=\"CF\">Central African Republic</option>\n" +
                    "	<option value=\"TD\">Chad</option>\n" +
                    "	<option value=\"CL\">Chile</option>\n" +
                    "	<option value=\"CN\">China</option>\n" +
                    "	<option value=\"CX\">Christmas Island</option>\n" +
                    "	<option value=\"CC\">Cocos (Keeling) Islands</option>\n" +
                    "	<option value=\"CO\">Colombia</option>\n" +
                    "	<option value=\"KM\">Comoros</option>\n" +
                    "	<option value=\"CG\">Congo</option>\n" +
                    "	<option value=\"CD\">Congo, the Democratic Republic of the</option>\n" +
                    "	<option value=\"CK\">Cook Islands</option>\n" +
                    "	<option value=\"CR\">Costa Rica</option>\n" +
                    "	<option value=\"CI\">Côte d'Ivoire</option>\n" +
                    "	<option value=\"HR\">Croatia</option>\n" +
                    "	<option value=\"CU\">Cuba</option>\n" +
                    "	<option value=\"CW\">Curaçao</option>\n" +
                    "	<option value=\"CY\">Cyprus</option>\n" +
                    "	<option value=\"CZ\">Czech Republic</option>\n" +
                    "	<option value=\"DK\">Denmark</option>\n" +
                    "	<option value=\"DJ\">Djibouti</option>\n" +
                    "	<option value=\"DM\">Dominica</option>\n" +
                    "	<option value=\"DO\">Dominican Republic</option>\n" +
                    "	<option value=\"EC\">Ecuador</option>\n" +
                    "	<option value=\"EG\">Egypt</option>\n" +
                    "	<option value=\"SV\">El Salvador</option>\n" +
                    "	<option value=\"GQ\">Equatorial Guinea</option>\n" +
                    "	<option value=\"ER\">Eritrea</option>\n" +
                    "	<option value=\"EE\">Estonia</option>\n" +
                    "	<option value=\"ET\">Ethiopia</option>\n" +
                    "	<option value=\"FK\">Falkland Islands (Malvinas)</option>\n" +
                    "	<option value=\"FO\">Faroe Islands</option>\n" +
                    "	<option value=\"FJ\">Fiji</option>\n" +
                    "	<option value=\"FI\">Finland</option>\n" +
                    "	<option value=\"FR\">France</option>\n" +
                    "	<option value=\"GF\">French Guiana</option>\n" +
                    "	<option value=\"PF\">French Polynesia</option>\n" +
                    "	<option value=\"TF\">French Southern Territories</option>\n" +
                    "	<option value=\"GA\">Gabon</option>\n" +
                    "	<option value=\"GM\">Gambia</option>\n" +
                    "	<option value=\"GE\">Georgia</option>\n" +
                    "	<option value=\"DE\">Germany</option>\n" +
                    "	<option value=\"GH\">Ghana</option>\n" +
                    "	<option value=\"GI\">Gibraltar</option>\n" +
                    "	<option value=\"GR\">Greece</option>\n" +
                    "	<option value=\"GL\">Greenland</option>\n" +
                    "	<option value=\"GD\">Grenada</option>\n" +
                    "	<option value=\"GP\">Guadeloupe</option>\n" +
                    "	<option value=\"GU\">Guam</option>\n" +
                    "	<option value=\"GT\">Guatemala</option>\n" +
                    "	<option value=\"GG\">Guernsey</option>\n" +
                    "	<option value=\"GN\">Guinea</option>\n" +
                    "	<option value=\"GW\">Guinea-Bissau</option>\n" +
                    "	<option value=\"GY\">Guyana</option>\n" +
                    "	<option value=\"HT\">Haiti</option>\n" +
                    "	<option value=\"HM\">Heard Island and McDonald Islands</option>\n" +
                    "	<option value=\"VA\">Holy See (Vatican City State)</option>\n" +
                    "	<option value=\"HN\">Honduras</option>\n" +
                    "	<option value=\"HK\">Hong Kong</option>\n" +
                    "	<option value=\"HU\">Hungary</option>\n" +
                    "	<option value=\"IS\">Iceland</option>\n" +
                    "	<option value=\"IN\">India</option>\n" +
                    "	<option value=\"ID\">Indonesia</option>\n" +
                    "	<option value=\"IR\">Iran, Islamic Republic of</option>\n" +
                    "	<option value=\"IQ\">Iraq</option>\n" +
                    "	<option value=\"IE\">Ireland</option>\n" +
                    "	<option value=\"IM\">Isle of Man</option>\n" +
                    "	<option value=\"IL\">Israel</option>\n" +
                    "	<option value=\"IT\">Italy</option>\n" +
                    "	<option value=\"JM\">Jamaica</option>\n" +
                    "	<option value=\"JP\">Japan</option>\n" +
                    "	<option value=\"JE\">Jersey</option>\n" +
                    "	<option value=\"JO\">Jordan</option>\n" +
                    "	<option value=\"KZ\">Kazakhstan</option>\n" +
                    "	<option value=\"KE\">Kenya</option>\n" +
                    "	<option value=\"KI\">Kiribati</option>\n" +
                    "	<option value=\"KP\">Korea, Democratic People's Republic of</option>\n" +
                    "	<option value=\"KR\">Korea, Republic of</option>\n" +
                    "	<option value=\"KW\">Kuwait</option>\n" +
                    "	<option value=\"KG\">Kyrgyzstan</option>\n" +
                    "	<option value=\"LA\">Lao People's Democratic Republic</option>\n" +
                    "	<option value=\"LV\">Latvia</option>\n" +
                    "	<option value=\"LB\">Lebanon</option>\n" +
                    "	<option value=\"LS\">Lesotho</option>\n" +
                    "	<option value=\"LR\">Liberia</option>\n" +
                    "	<option value=\"LY\">Libya</option>\n" +
                    "	<option value=\"LI\">Liechtenstein</option>\n" +
                    "	<option value=\"LT\">Lithuania</option>\n" +
                    "	<option value=\"LU\">Luxembourg</option>\n" +
                    "	<option value=\"MO\">Macao</option>\n" +
                    "	<option value=\"MK\">Macedonia, the former Yugoslav Republic of</option>\n" +
                    "	<option value=\"MG\">Madagascar</option>\n" +
                    "	<option value=\"MW\">Malawi</option>\n" +
                    "	<option value=\"MY\">Malaysia</option>\n" +
                    "	<option value=\"MV\">Maldives</option>\n" +
                    "	<option value=\"ML\">Mali</option>\n" +
                    "	<option value=\"MT\">Malta</option>\n" +
                    "	<option value=\"MH\">Marshall Islands</option>\n" +
                    "	<option value=\"MQ\">Martinique</option>\n" +
                    "	<option value=\"MR\">Mauritania</option>\n" +
                    "	<option value=\"MU\">Mauritius</option>\n" +
                    "	<option value=\"YT\">Mayotte</option>\n" +
                    "	<option value=\"MX\">Mexico</option>\n" +
                    "	<option value=\"FM\">Micronesia, Federated States of</option>\n" +
                    "	<option value=\"MD\">Moldova, Republic of</option>\n" +
                    "	<option value=\"MC\">Monaco</option>\n" +
                    "	<option value=\"MN\">Mongolia</option>\n" +
                    "	<option value=\"ME\">Montenegro</option>\n" +
                    "	<option value=\"MS\">Montserrat</option>\n" +
                    "	<option value=\"MA\">Morocco</option>\n" +
                    "	<option value=\"MZ\">Mozambique</option>\n" +
                    "	<option value=\"MM\">Myanmar</option>\n" +
                    "	<option value=\"NA\">Namibia</option>\n" +
                    "	<option value=\"NR\">Nauru</option>\n" +
                    "	<option value=\"NP\">Nepal</option>\n" +
                    "	<option value=\"NL\">Netherlands</option>\n" +
                    "	<option value=\"NC\">New Caledonia</option>\n" +
                    "	<option value=\"NZ\">New Zealand</option>\n" +
                    "	<option value=\"NI\">Nicaragua</option>\n" +
                    "	<option value=\"NE\">Niger</option>\n" +
                    "	<option value=\"NG\">Nigeria</option>\n" +
                    "	<option value=\"NU\">Niue</option>\n" +
                    "	<option value=\"NF\">Norfolk Island</option>\n" +
                    "	<option value=\"MP\">Northern Mariana Islands</option>\n" +
                    "	<option value=\"NO\">Norway</option>\n" +
                    "	<option value=\"OM\">Oman</option>\n" +
                    "	<option value=\"PK\">Pakistan</option>\n" +
                    "	<option value=\"PW\">Palau</option>\n" +
                    "	<option value=\"PS\">Palestinian Territory, Occupied</option>\n" +
                    "	<option value=\"PA\">Panama</option>\n" +
                    "	<option value=\"PG\">Papua New Guinea</option>\n" +
                    "	<option value=\"PY\">Paraguay</option>\n" +
                    "	<option value=\"PE\">Peru</option>\n" +
                    "	<option value=\"PH\">Philippines</option>\n" +
                    "	<option value=\"PN\">Pitcairn</option>\n" +
                    "	<option value=\"PL\">Poland</option>\n" +
                    "	<option value=\"PT\">Portugal</option>\n" +
                    "	<option value=\"PR\">Puerto Rico</option>\n" +
                    "	<option value=\"QA\">Qatar</option>\n" +
                    "	<option value=\"RE\">Réunion</option>\n" +
                    "	<option value=\"RO\">Romania</option>\n" +
                    "	<option value=\"RU\">Russian Federation</option>\n" +
                    "	<option value=\"RW\">Rwanda</option>\n" +
                    "	<option value=\"BL\">Saint Barthélemy</option>\n" +
                    "	<option value=\"SH\">Saint Helena, Ascension and Tristan da Cunha</option>\n" +
                    "	<option value=\"KN\">Saint Kitts and Nevis</option>\n" +
                    "	<option value=\"LC\">Saint Lucia</option>\n" +
                    "	<option value=\"MF\">Saint Martin (French part)</option>\n" +
                    "	<option value=\"PM\">Saint Pierre and Miquelon</option>\n" +
                    "	<option value=\"VC\">Saint Vincent and the Grenadines</option>\n" +
                    "	<option value=\"WS\">Samoa</option>\n" +
                    "	<option value=\"SM\">San Marino</option>\n" +
                    "	<option value=\"ST\">Sao Tome and Principe</option>\n" +
                    "	<option value=\"SA\">Saudi Arabia</option>\n" +
                    "	<option value=\"SN\">Senegal</option>\n" +
                    "	<option value=\"RS\">Serbia</option>\n" +
                    "	<option value=\"SC\">Seychelles</option>\n" +
                    "	<option value=\"SL\">Sierra Leone</option>\n" +
                    "	<option value=\"SG\">Singapore</option>\n" +
                    "	<option value=\"SX\">Sint Maarten (Dutch part)</option>\n" +
                    "	<option value=\"SK\">Slovakia</option>\n" +
                    "	<option value=\"SI\">Slovenia</option>\n" +
                    "	<option value=\"SB\">Solomon Islands</option>\n" +
                    "	<option value=\"SO\">Somalia</option>\n" +
                    "	<option value=\"ZA\">South Africa</option>\n" +
                    "	<option value=\"GS\">South Georgia and the South Sandwich Islands</option>\n" +
                    "	<option value=\"SS\">South Sudan</option>\n" +
                    "	<option value=\"ES\">Spain</option>\n" +
                    "	<option value=\"LK\">Sri Lanka</option>\n" +
                    "	<option value=\"SD\">Sudan</option>\n" +
                    "	<option value=\"SR\">Suriname</option>\n" +
                    "	<option value=\"SJ\">Svalbard and Jan Mayen</option>\n" +
                    "	<option value=\"SZ\">Swaziland</option>\n" +
                    "	<option value=\"SE\">Sweden</option>\n" +
                    "	<option value=\"CH\">Switzerland</option>\n" +
                    "	<option value=\"SY\">Syrian Arab Republic</option>\n" +
                    "	<option value=\"TW\">Taiwan, Province of China</option>\n" +
                    "	<option value=\"TJ\">Tajikistan</option>\n" +
                    "	<option value=\"TZ\">Tanzania, United Republic of</option>\n" +
                    "	<option value=\"TH\">Thailand</option>\n" +
                    "	<option value=\"TL\">Timor-Leste</option>\n" +
                    "	<option value=\"TG\">Togo</option>\n" +
                    "	<option value=\"TK\">Tokelau</option>\n" +
                    "	<option value=\"TO\">Tonga</option>\n" +
                    "	<option value=\"TT\">Trinidad and Tobago</option>\n" +
                    "	<option value=\"TN\">Tunisia</option>\n" +
                    "	<option value=\"TR\">Turkey</option>\n" +
                    "	<option value=\"TM\">Turkmenistan</option>\n" +
                    "	<option value=\"TC\">Turks and Caicos Islands</option>\n" +
                    "	<option value=\"TV\">Tuvalu</option>\n" +
                    "	<option value=\"UG\">Uganda</option>\n" +
                    "	<option value=\"UA\">Ukraine</option>\n" +
                    "	<option value=\"AE\">United Arab Emirates</option>\n" +
                    "	<option value=\"GB\">United Kingdom</option>\n" +
                    "	<option value=\"US\">United States</option>\n" +
                    "	<option value=\"UM\">United States Minor Outlying Islands</option>\n" +
                    "	<option value=\"UY\">Uruguay</option>\n" +
                    "	<option value=\"UZ\">Uzbekistan</option>\n" +
                    "	<option value=\"VU\">Vanuatu</option>\n" +
                    "	<option value=\"VE\">Venezuela, Bolivarian Republic of</option>\n" +
                    "	<option value=\"VN\">Viet Nam</option>\n" +
                    "	<option value=\"VG\">Virgin Islands, British</option>\n" +
                    "	<option value=\"VI\">Virgin Islands, U.S.</option>\n" +
                    "	<option value=\"WF\">Wallis and Futuna</option>\n" +
                    "	<option value=\"EH\">Western Sahara</option>\n" +
                    "	<option value=\"YE\">Yemen</option>\n" +
                    "	<option value=\"ZM\">Zambia</option>\n" +
                    "	<option value=\"ZW\">Zimbabwe</option>");
            
            out.println("</select><br>"); 
    
            out.println("<label for='city'>*Πόλη:</label> ");
            out.println("<input id='city' type='text' name='city' maxlength='50' onchange='validateCity(this.value);' >");
            out.println("<nav style='font-size:12px;'>Aπο 2 εως 50 χαρακτήρες</nav><br>");
            out.println("<label for='info'>Περισσότερες Πληροφορίες:</label> ");
            out.println("<input id='info' type='text' name='info' onchange='validateInfo(this.value);' maxlength='500'><br>");
            out.println("Τα πεδία με * είναι απαραίτητο να συμπληρωθούν<br>");
            out.println("&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;");
            out.println("<input class='button' id='but2' type='button' value=\"Εγγραφή\" onclick='sendInfo();'>");
            }
            
        }  else if("sendInfo".equals(fname)){
           
             String uname=request.getParameter("uname");
       String email=request.getParameter("email");
       String password=request.getParameter("password");
       String vpassword=request.getParameter("vpassword");
       String firstName=request.getParameter("firstname");
       String lastName=request.getParameter("lastname");
       String dob=request.getParameter("dob");
       String gender=request.getParameter("gender");
       String country=request.getParameter("country");
       String city=request.getParameter("city");
       String info=request.getParameter("info");
       User us=new User(uname,email,password,firstName,lastName,dob,country,city,info,gender);
       
       int flag1=0;
       int flag2=0;
      
           if(UserDB.checkValidEmail(email)==false){
               flag1=1;
           }
           if(UserDB.checkValidUserName(uname)==false){
               flag2=1;
           }
       
       if(flag1==0 && flag2==0){
          UserDB.addUser(us);
           out.println("<h2>Συγχαρητηρία "+firstName+", η εγγραφή σας ολοκληρώθηκε επιτυχώς με τα παρακάτω στοιχεία, μπορείτε τώρα να κάνετε Login</h2><br>");
           out.println("Username:"+ uname +"<br>");
           out.println("Email:"+ email +"<br>");
           out.println("First Name:"+firstName +"<br>");
           out.println("Last Name:"+ lastName +"<br>");
           out.println("Country:"+country +"<br>");
           out.println("City:"+ city +"<br>");
           out.println("Date of Birth:"+dob +"<br>");
           out.println("Gender:"+ gender +"<br>");
           out.println("Info:"+ info +"<br>");
           out.println(" <input class='button' id='but' type='button' value=\"Login\" onclick='login();' >");
       }else if(flag1!=0){
           out.println("Το Email: "+email+" Χρησιμοποιείτε ήδη παρακαλώ δοκιμάστε ξανά<br>");
          out.println( "<input class='button' id='but1' type='button' value='Sign up' onclick='sendAjaxGet();'>");
       }else if(flag2!=0){
           out.println("Το Username: "+uname+" Χρησιμοποιείτε ήδη παρακαλώ δοκιμάστε ξανά<br>");
          out.println( "<input class='button' id='but1' type='button' value='Sign up' onclick='sendAjaxGet();'>");
       }
       
       
        }else if("login".equals(fname)){
            int found1=0;
            if(requestCookies==null){
                Cookie sessionCookie=new Cookie("mySessionCookie",""+rand.nextInt());
                response.addCookie(sessionCookie);
                myCookies.add(sessionCookie);
            }else{
                int z=0;
                for (Cookie reqCookie : requestCookies) {
                   
                    for (Cookie myCookie : myCookies) {
                        String cook=myCookie.getValue();
                        if(cook.equals(requestCookies[z].getValue())){
                            for(int i=0;i<loggedIn.size();i++){
                                if(!loggedIn.isEmpty()){
                                    found1=1;
                                    out.println("<input id='uname' type='hidden' name='username' value='"+loggedIn.get(i).getEmail()+"'><br>");
                                    out.println("<h3>Καλωσήρθες "+ loggedIn.get(i).getUserName()+"</h3> <br>");
                                    out.println("Τα στοιχεία του λογαριασμού σου είναι: <br>");
                                    out.println("Username:"+ loggedIn.get(i).getUserName() +"<br>");
                                    out.println("Email:"+ loggedIn.get(i).getEmail() +"<br>");
                                    out.println("First Name:"+loggedIn.get(i).getFirstName()+"<br>");
                                    out.println("Last Name:"+ loggedIn.get(i).getLastName() +"<br>");
                                    out.println("Country:"+loggedIn.get(i).getCountry()+"<br>");
                                    out.println("City:"+ loggedIn.get(i).getTown() +"<br>");
                                    out.println("Date of Birth:"+loggedIn.get(i).getBirthDate()+"<br>");
                                    out.println("Gender:"+ loggedIn.get(i).getGender()+"<br>");
                                    out.println("Info:"+ loggedIn.get(i).getInfo()+"<br>");
                                    
                                    out.println("Αλλοι Χρήστες:<br>");
                                    out.println("<ul>");
                                    for(int y=0;y<A.size();y++){
                                        if(!(loggedIn.get(i).getUserName()).equals(A.get(y).getUserName()) ){
                                            out.println("<li>Username:"+ A.get(y).getUserName() +" &emsp; Email: "+A.get(y).getEmail()+" <input class='button' id='but6' type='button' value=\"Show my Photos\" onclick='coll_of_imgs1(\""+A.get(y).getUserName()+"\");'  ></li> ");
                                        }
                                    }
                                    out.println("</ul>");
                                    out.println(" <input class='button' id='but3' type='button' value=\"Edit Account\" onclick='showAccount();'  >");
                                    out.println(" <input class='button' id='but4' type='button' value=\"Sign Out\" onclick='signOut();'  >");
                                    out.println(" <input class='button' id='but6' type='button' value=\"Show my Photos\" onclick='coll_of_imgs();'  >");
                                    out.println(" <input class='button' id='but7' type='button' value=\"Upload\" onclick='enableUpload();'  >");
                                     
                                     
                                }
                            }
                        }
                    }
                    z++;
                }
                    
            
            }
            if(found1==0){
                out.println("<label for='username'>*Username:</label> ");
                out.println("<input id='uname'  type='text' name='username' onchange='validateUsername(this.value);' required><br>");
                out.println("<label for='password'>*Κωδικός:</label>");
                out.println("<input id='password'  type='password' name='password' onchange='validatePassword(this.value);' required><br>");
                out.println(" <input class='button' id='but' type='button' value=\"Login\" onclick='sendlogin();'  >");
            }
            
        }else if("sendlogin".equals(fname)){
            
            String uname=request.getParameter("uname");
            String pasword=request.getParameter("password");
            int found=0;
            User us=UserDB.getUser(uname);
            loggedIn.add(us);
                if(us.getUserName()!=null ){
                    if(pasword.equals(us.getPassword())){
                        found=1;
                     
                        out.println("<h3>Επιτυχής Είσοδος</h3><br>");
                        out.println("<h3>Καλωσήρθες "+ us.getUserName() +"</h3> <br>");
                        out.println("Τα στοιχεία του λογαριασμού σου είναι: <br>");
                         out.println("Username:"+ us.getUserName() +"<br>");
                        out.println("Email:"+ us.getEmail() +"<br>");
                        out.println("First Name:"+us.getFirstName() +"<br>");
                        out.println("Last Name:"+ us.getLastName() +"<br>");
                        out.println("Country:"+us.getCountry() +"<br>");
                        out.println("City:"+ us.getTown() +"<br>");
                        out.println("Date of Birth:"+us.getBirthDate() +"<br>");
                        out.println("Gender:"+ us.getGender() +"<br>");
                        out.println("Info:"+ us.getInfo() +"<br>");
                        out.println("Αλλοι Χρήστες:<br>");
                        out.println("<ul>");
                        for(int y=0;y<A.size();y++){
                            if(!uname.equals(A.get(y).getUserName()) ){
                                            out.println("<li>Username:"+ A.get(y).getUserName() +" &emsp; Email: "+A.get(y).getEmail()+" <input class='button' id='but6' type='button' value=\"Show my Photos\" onclick='coll_of_imgs1(\""+A.get(y).getUserName()+"\");'  ></li> ");
                            }
                        }
                        out.println("</ul>");
                        out.println(" <input class='button' id='but3' type='button' value=\"Edit Account\" onclick='showAccount();'  >");
                        out.println(" <input class='button' id='but4' type='button' value=\"Sign Out\" onclick='signOut();'  >");
                        out.println(" <input class='button' id='but6' type='button' value=\"Show my Photos\" onclick='coll_of_imgs();'  >");
                         out.println(" <input class='button' id='but7' type='button' value=\"Upload\" onclick='enableUpload();'  >");
                          out.println(" <input class='button' id='but8 type='button' value=\"Delete User\" onclick='DeleteUser();'  >");
                          
                           
                    }else{
                    out.println("Wrong Password");
                    }
                    
                }
             
             if(found==0){
                    out.println("Wrong Username, Try Again<br>");
                    out.println("<label for='username'>*Username:</label> ");
                    out.println("<input id='uname' type='text' name='username' onchange=\"validateUsername(this.value);\" required><br>");
                    out.println("<label for='password'>*Κωδικός:</label>");
                    out.println("<input id='password' type='password' name='password' onchange='validatePassword(this.value);' required><br>");
                    out.println(" <input class='button' id='but' type='button' value=\"Login\" onclick='sendlogin();'  >");
                     out.println("<input class='button' id='but1' type='button' value='Sign up' onclick='sendAjaxGet();'>");
                }
             
        }else if("showAccount".equals(fname)){
           String uname=request.getParameter("uname");
            User us=UserDB.getUser(uname);
                    
           out.println("<label for='uname'>*Όνομα Χρήστη:</label>");
            out.println("<input id='uname' type='text' name='username' value='"+us.getUserName()+"'  onchange='validateUsername(this.value);'>");
             out.println("<nav style='font-size:12px;'>Tουλάχιστον 8 χαρακτήρες</nav><br>");
            out.println("<label for='email'>*Email:</label> ");
            out.println("<input id='email' type='email' name='email' value='"+us.getEmail()+"' onchange='validateEmail(this.value);' ><br>");
            out.println("<label for='password'>*Κωδικός:</label>");
            out.println("<input id='password' type='password' name='password' value='"+us.getPassword()+"' onchange='validatePassword(this.value);' >");
            out.println("<nav style='font-size:12px;'>Κωδικός Χρήστη, απο 6 εως 10 χαρακτήρες, περιέχει τουλάχιστον ένα λατινικό γραμμα,έναν αριθμό και ένα σύμβολο(#,$,%,!)</nav><br>");
            out.println("<label for='vpassword'>*Επιβεβαίωση Κωδικού:</label>");
            out.println("<input id='vpassword' type='password' name='vpassword' value='"+us.getPassword()+"' onchange='validateVpassword(this.value);' >");
            out.println("<nav style='font-size:12px;'>Επιβεβαίωση Κωδικού Χρήστη</nav><br>");
            out.println("<label for='firstname'>*Όνομα:</label>");
            out.println("<input id='firstname' type='text' name='firstname' value='"+us.getFirstName()+"' onchange='validateFname(this.value);'  >");
            out.println("<nav style='font-size:12px;'>Aπο 3 εως 20 χαρακτήρες</nav><br>");
            out.println("<label for='lastname'>*Επώνυμο:</label>");
            out.println("<input id='lastname' type='text' name='lastname' value='"+us.getLastName()+"' onchange='validateLname(this.value);' >");
            out.println("<nav style='font-size:12px;'>Aπο 4 εως 20 χαρακτήρες</nav><br>");
            out.println("<label for='dob'>*Ημερομηνία Γέννησης:</label>");
            out.println("<input id='dob' type='date' name='dob' max='2001-11-16' value='"+us.getBirthDate()+"' >");
            out.println("<nav style='font-size:12px;'>Η εγγραφή επιτρέπεται σε άτομα μεγαλύτερα των 15 ετών</nav><br>");
            out.println("<label for='gender'>Φύλο:</label>");
           out.println("<form>"); 
           out.println("<input id='gender'  type=\"radio\" name=\"gender\" value=\"male\" >Άνδρας");     
           out.println("<input id='gender1' type=\"radio\" name=\"gender\" value=\"female\">Γυναίκα");     
           out.println("<input id='gender2' type=\"radio\" name=\"gender\" value=\"other\">Άλλο<br><br>");    
           out.println("</form> ");      
            out.println("<label for='country'>*Χώρα:</label>");
            out.println("<select id='country' name='country' required>");
            out.println("<option value='"+us.getCountry()+"'</option>");
            out.println("<option value=\"GR\">Greece</option>" +
                        "<option value=\"AF\">Afghanistan</option>" +
                        "<option value=\"AX\">Åland Islands</option>" +
                    "<option value=\"AL\">Albania</option>\n" +
                    "	<option value=\"DZ\">Algeria</option>\n" +
                    "	<option value=\"AS\">American Samoa</option>\n" +
                    "	<option value=\"AD\">Andorra</option>" +
                                        "<option value=\"AO\">Angola</option>\n" +
                    "	<option value=\"AI\">Anguilla</option>\n" +
                    "	<option value=\"AQ\">Antarctica</option>\n" +
                    "	<option value=\"AG\">Antigua and Barbuda</option>\n" +
                    "	<option value=\"AR\">Argentina</option>\n" +
                    "	<option value=\"AM\">Armenia</option>\n" +
                    "	<option value=\"AW\">Aruba</option>\n" +
                    "	<option value=\"AU\">Australia</option>\n" +
                    "	<option value=\"AT\">Austria</option>\n" +
                    "	<option value=\"AZ\">Azerbaijan</option>\n" +
                    "	<option value=\"BS\">Bahamas</option>\n" +
                    "	<option value=\"BH\">Bahrain</option>\n" +
                    "	<option value=\"BD\">Bangladesh</option>\n" +
                    "	<option value=\"BB\">Barbados</option>\n" +
                    "	<option value=\"BY\">Belarus</option>\n" +
                    "	<option value=\"BE\">Belgium</option>\n" +
                    "	<option value=\"BZ\">Belize</option>\n" +
                    "	<option value=\"BJ\">Benin</option>\n" +
                    "	<option value=\"BM\">Bermuda</option>\n" +
                    "	<option value=\"BT\">Bhutan</option>\n" +
                    "	<option value=\"BO\">Bolivia, Plurinational State of</option>\n" +
                    "	<option value=\"BQ\">Bonaire, Sint Eustatius and Saba</option>\n" +
                    "	<option value=\"BA\">Bosnia and Herzegovina</option>\n" +
                    "	<option value=\"BW\">Botswana</option>\n" +
                    "	<option value=\"BV\">Bouvet Island</option>\n" +
                    "	<option value=\"BR\">Brazil</option>\n" +
                    "	<option value=\"IO\">British Indian Ocean Territory</option>\n" +
                    "	<option value=\"BN\">Brunei Darussalam</option>\n" +
                    "	<option value=\"BG\">Bulgaria</option>\n" +
                    "	<option value=\"BF\">Burkina Faso</option>\n" +
                    "	<option value=\"BI\">Burundi</option>\n" +
                    "	<option value=\"KH\">Cambodia</option>\n" +
                    "	<option value=\"CM\">Cameroon</option>\n" +
                    "	<option value=\"CA\">Canada</option>\n" +
                    "	<option value=\"CV\">Cape Verde</option>\n" +
                    "	<option value=\"KY\">Cayman Islands</option>\n" +
                    "	<option value=\"CF\">Central African Republic</option>\n" +
                    "	<option value=\"TD\">Chad</option>\n" +
                    "	<option value=\"CL\">Chile</option>\n" +
                    "	<option value=\"CN\">China</option>\n" +
                    "	<option value=\"CX\">Christmas Island</option>\n" +
                    "	<option value=\"CC\">Cocos (Keeling) Islands</option>\n" +
                    "	<option value=\"CO\">Colombia</option>\n" +
                    "	<option value=\"KM\">Comoros</option>\n" +
                    "	<option value=\"CG\">Congo</option>\n" +
                    "	<option value=\"CD\">Congo, the Democratic Republic of the</option>\n" +
                    "	<option value=\"CK\">Cook Islands</option>\n" +
                    "	<option value=\"CR\">Costa Rica</option>\n" +
                    "	<option value=\"CI\">Côte d'Ivoire</option>\n" +
                    "	<option value=\"HR\">Croatia</option>\n" +
                    "	<option value=\"CU\">Cuba</option>\n" +
                    "	<option value=\"CW\">Curaçao</option>\n" +
                    "	<option value=\"CY\">Cyprus</option>\n" +
                    "	<option value=\"CZ\">Czech Republic</option>\n" +
                    "	<option value=\"DK\">Denmark</option>\n" +
                    "	<option value=\"DJ\">Djibouti</option>\n" +
                    "	<option value=\"DM\">Dominica</option>\n" +
                    "	<option value=\"DO\">Dominican Republic</option>\n" +
                    "	<option value=\"EC\">Ecuador</option>\n" +
                    "	<option value=\"EG\">Egypt</option>\n" +
                    "	<option value=\"SV\">El Salvador</option>\n" +
                    "	<option value=\"GQ\">Equatorial Guinea</option>\n" +
                    "	<option value=\"ER\">Eritrea</option>\n" +
                    "	<option value=\"EE\">Estonia</option>\n" +
                    "	<option value=\"ET\">Ethiopia</option>\n" +
                    "	<option value=\"FK\">Falkland Islands (Malvinas)</option>\n" +
                    "	<option value=\"FO\">Faroe Islands</option>\n" +
                    "	<option value=\"FJ\">Fiji</option>\n" +
                    "	<option value=\"FI\">Finland</option>\n" +
                    "	<option value=\"FR\">France</option>\n" +
                    "	<option value=\"GF\">French Guiana</option>\n" +
                    "	<option value=\"PF\">French Polynesia</option>\n" +
                    "	<option value=\"TF\">French Southern Territories</option>\n" +
                    "	<option value=\"GA\">Gabon</option>\n" +
                    "	<option value=\"GM\">Gambia</option>\n" +
                    "	<option value=\"GE\">Georgia</option>\n" +
                    "	<option value=\"DE\">Germany</option>\n" +
                    "	<option value=\"GH\">Ghana</option>\n" +
                    "	<option value=\"GI\">Gibraltar</option>\n" +
                    "	<option value=\"GR\">Greece</option>\n" +
                    "	<option value=\"GL\">Greenland</option>\n" +
                    "	<option value=\"GD\">Grenada</option>\n" +
                    "	<option value=\"GP\">Guadeloupe</option>\n" +
                    "	<option value=\"GU\">Guam</option>\n" +
                    "	<option value=\"GT\">Guatemala</option>\n" +
                    "	<option value=\"GG\">Guernsey</option>\n" +
                    "	<option value=\"GN\">Guinea</option>\n" +
                    "	<option value=\"GW\">Guinea-Bissau</option>\n" +
                    "	<option value=\"GY\">Guyana</option>\n" +
                    "	<option value=\"HT\">Haiti</option>\n" +
                    "	<option value=\"HM\">Heard Island and McDonald Islands</option>\n" +
                    "	<option value=\"VA\">Holy See (Vatican City State)</option>\n" +
                    "	<option value=\"HN\">Honduras</option>\n" +
                    "	<option value=\"HK\">Hong Kong</option>\n" +
                    "	<option value=\"HU\">Hungary</option>\n" +
                    "	<option value=\"IS\">Iceland</option>\n" +
                    "	<option value=\"IN\">India</option>\n" +
                    "	<option value=\"ID\">Indonesia</option>\n" +
                    "	<option value=\"IR\">Iran, Islamic Republic of</option>\n" +
                    "	<option value=\"IQ\">Iraq</option>\n" +
                    "	<option value=\"IE\">Ireland</option>\n" +
                    "	<option value=\"IM\">Isle of Man</option>\n" +
                    "	<option value=\"IL\">Israel</option>\n" +
                    "	<option value=\"IT\">Italy</option>\n" +
                    "	<option value=\"JM\">Jamaica</option>\n" +
                    "	<option value=\"JP\">Japan</option>\n" +
                    "	<option value=\"JE\">Jersey</option>\n" +
                    "	<option value=\"JO\">Jordan</option>\n" +
                    "	<option value=\"KZ\">Kazakhstan</option>\n" +
                    "	<option value=\"KE\">Kenya</option>\n" +
                    "	<option value=\"KI\">Kiribati</option>\n" +
                    "	<option value=\"KP\">Korea, Democratic People's Republic of</option>\n" +
                    "	<option value=\"KR\">Korea, Republic of</option>\n" +
                    "	<option value=\"KW\">Kuwait</option>\n" +
                    "	<option value=\"KG\">Kyrgyzstan</option>\n" +
                    "	<option value=\"LA\">Lao People's Democratic Republic</option>\n" +
                    "	<option value=\"LV\">Latvia</option>\n" +
                    "	<option value=\"LB\">Lebanon</option>\n" +
                    "	<option value=\"LS\">Lesotho</option>\n" +
                    "	<option value=\"LR\">Liberia</option>\n" +
                    "	<option value=\"LY\">Libya</option>\n" +
                    "	<option value=\"LI\">Liechtenstein</option>\n" +
                    "	<option value=\"LT\">Lithuania</option>\n" +
                    "	<option value=\"LU\">Luxembourg</option>\n" +
                    "	<option value=\"MO\">Macao</option>\n" +
                    "	<option value=\"MK\">Macedonia, the former Yugoslav Republic of</option>\n" +
                    "	<option value=\"MG\">Madagascar</option>\n" +
                    "	<option value=\"MW\">Malawi</option>\n" +
                    "	<option value=\"MY\">Malaysia</option>\n" +
                    "	<option value=\"MV\">Maldives</option>\n" +
                    "	<option value=\"ML\">Mali</option>\n" +
                    "	<option value=\"MT\">Malta</option>\n" +
                    "	<option value=\"MH\">Marshall Islands</option>\n" +
                    "	<option value=\"MQ\">Martinique</option>\n" +
                    "	<option value=\"MR\">Mauritania</option>\n" +
                    "	<option value=\"MU\">Mauritius</option>\n" +
                    "	<option value=\"YT\">Mayotte</option>\n" +
                    "	<option value=\"MX\">Mexico</option>\n" +
                    "	<option value=\"FM\">Micronesia, Federated States of</option>\n" +
                    "	<option value=\"MD\">Moldova, Republic of</option>\n" +
                    "	<option value=\"MC\">Monaco</option>\n" +
                    "	<option value=\"MN\">Mongolia</option>\n" +
                    "	<option value=\"ME\">Montenegro</option>\n" +
                    "	<option value=\"MS\">Montserrat</option>\n" +
                    "	<option value=\"MA\">Morocco</option>\n" +
                    "	<option value=\"MZ\">Mozambique</option>\n" +
                    "	<option value=\"MM\">Myanmar</option>\n" +
                    "	<option value=\"NA\">Namibia</option>\n" +
                    "	<option value=\"NR\">Nauru</option>\n" +
                    "	<option value=\"NP\">Nepal</option>\n" +
                    "	<option value=\"NL\">Netherlands</option>\n" +
                    "	<option value=\"NC\">New Caledonia</option>\n" +
                    "	<option value=\"NZ\">New Zealand</option>\n" +
                    "	<option value=\"NI\">Nicaragua</option>\n" +
                    "	<option value=\"NE\">Niger</option>\n" +
                    "	<option value=\"NG\">Nigeria</option>\n" +
                    "	<option value=\"NU\">Niue</option>\n" +
                    "	<option value=\"NF\">Norfolk Island</option>\n" +
                    "	<option value=\"MP\">Northern Mariana Islands</option>\n" +
                    "	<option value=\"NO\">Norway</option>\n" +
                    "	<option value=\"OM\">Oman</option>\n" +
                    "	<option value=\"PK\">Pakistan</option>\n" +
                    "	<option value=\"PW\">Palau</option>\n" +
                    "	<option value=\"PS\">Palestinian Territory, Occupied</option>\n" +
                    "	<option value=\"PA\">Panama</option>\n" +
                    "	<option value=\"PG\">Papua New Guinea</option>\n" +
                    "	<option value=\"PY\">Paraguay</option>\n" +
                    "	<option value=\"PE\">Peru</option>\n" +
                    "	<option value=\"PH\">Philippines</option>\n" +
                    "	<option value=\"PN\">Pitcairn</option>\n" +
                    "	<option value=\"PL\">Poland</option>\n" +
                    "	<option value=\"PT\">Portugal</option>\n" +
                    "	<option value=\"PR\">Puerto Rico</option>\n" +
                    "	<option value=\"QA\">Qatar</option>\n" +
                    "	<option value=\"RE\">Réunion</option>\n" +
                    "	<option value=\"RO\">Romania</option>\n" +
                    "	<option value=\"RU\">Russian Federation</option>\n" +
                    "	<option value=\"RW\">Rwanda</option>\n" +
                    "	<option value=\"BL\">Saint Barthélemy</option>\n" +
                    "	<option value=\"SH\">Saint Helena, Ascension and Tristan da Cunha</option>\n" +
                    "	<option value=\"KN\">Saint Kitts and Nevis</option>\n" +
                    "	<option value=\"LC\">Saint Lucia</option>\n" +
                    "	<option value=\"MF\">Saint Martin (French part)</option>\n" +
                    "	<option value=\"PM\">Saint Pierre and Miquelon</option>\n" +
                    "	<option value=\"VC\">Saint Vincent and the Grenadines</option>\n" +
                    "	<option value=\"WS\">Samoa</option>\n" +
                    "	<option value=\"SM\">San Marino</option>\n" +
                    "	<option value=\"ST\">Sao Tome and Principe</option>\n" +
                    "	<option value=\"SA\">Saudi Arabia</option>\n" +
                    "	<option value=\"SN\">Senegal</option>\n" +
                    "	<option value=\"RS\">Serbia</option>\n" +
                    "	<option value=\"SC\">Seychelles</option>\n" +
                    "	<option value=\"SL\">Sierra Leone</option>\n" +
                    "	<option value=\"SG\">Singapore</option>\n" +
                    "	<option value=\"SX\">Sint Maarten (Dutch part)</option>\n" +
                    "	<option value=\"SK\">Slovakia</option>\n" +
                    "	<option value=\"SI\">Slovenia</option>\n" +
                    "	<option value=\"SB\">Solomon Islands</option>\n" +
                    "	<option value=\"SO\">Somalia</option>\n" +
                    "	<option value=\"ZA\">South Africa</option>\n" +
                    "	<option value=\"GS\">South Georgia and the South Sandwich Islands</option>\n" +
                    "	<option value=\"SS\">South Sudan</option>\n" +
                    "	<option value=\"ES\">Spain</option>\n" +
                    "	<option value=\"LK\">Sri Lanka</option>\n" +
                    "	<option value=\"SD\">Sudan</option>\n" +
                    "	<option value=\"SR\">Suriname</option>\n" +
                    "	<option value=\"SJ\">Svalbard and Jan Mayen</option>\n" +
                    "	<option value=\"SZ\">Swaziland</option>\n" +
                    "	<option value=\"SE\">Sweden</option>\n" +
                    "	<option value=\"CH\">Switzerland</option>\n" +
                    "	<option value=\"SY\">Syrian Arab Republic</option>\n" +
                    "	<option value=\"TW\">Taiwan, Province of China</option>\n" +
                    "	<option value=\"TJ\">Tajikistan</option>\n" +
                    "	<option value=\"TZ\">Tanzania, United Republic of</option>\n" +
                    "	<option value=\"TH\">Thailand</option>\n" +
                    "	<option value=\"TL\">Timor-Leste</option>\n" +
                    "	<option value=\"TG\">Togo</option>\n" +
                    "	<option value=\"TK\">Tokelau</option>\n" +
                    "	<option value=\"TO\">Tonga</option>\n" +
                    "	<option value=\"TT\">Trinidad and Tobago</option>\n" +
                    "	<option value=\"TN\">Tunisia</option>\n" +
                    "	<option value=\"TR\">Turkey</option>\n" +
                    "	<option value=\"TM\">Turkmenistan</option>\n" +
                    "	<option value=\"TC\">Turks and Caicos Islands</option>\n" +
                    "	<option value=\"TV\">Tuvalu</option>\n" +
                    "	<option value=\"UG\">Uganda</option>\n" +
                    "	<option value=\"UA\">Ukraine</option>\n" +
                    "	<option value=\"AE\">United Arab Emirates</option>\n" +
                    "	<option value=\"GB\">United Kingdom</option>\n" +
                    "	<option value=\"US\">United States</option>\n" +
                    "	<option value=\"UM\">United States Minor Outlying Islands</option>\n" +
                    "	<option value=\"UY\">Uruguay</option>\n" +
                    "	<option value=\"UZ\">Uzbekistan</option>\n" +
                    "	<option value=\"VU\">Vanuatu</option>\n" +
                    "	<option value=\"VE\">Venezuela, Bolivarian Republic of</option>\n" +
                    "	<option value=\"VN\">Viet Nam</option>\n" +
                    "	<option value=\"VG\">Virgin Islands, British</option>\n" +
                    "	<option value=\"VI\">Virgin Islands, U.S.</option>\n" +
                    "	<option value=\"WF\">Wallis and Futuna</option>\n" +
                    "	<option value=\"EH\">Western Sahara</option>\n" +
                    "	<option value=\"YE\">Yemen</option>\n" +
                    "	<option value=\"ZM\">Zambia</option>\n" +
                    "	<option value=\"ZW\">Zimbabwe</option>");
            
            out.println("</select><br>"); 
    
            out.println("<label for='city'>*Πόλη:</label> ");
            out.println("<input id='city' type='text' name='city' maxlength='50' value='"+us.getTown()+"' onchange='validateCity(this.value);' >");
            out.println("<nav style='font-size:12px;'>Aπο 2 εως 50 χαρακτήρες</nav><br>");
            out.println("<label for='info'>Περισσότερες Πληροφορίες:</label> ");
            out.println("<input id='info' type='text' name='info' onchange='validateInfo(this.value);' maxlength='500' value='"+us.getInfo()+"' ><br>");
            out.println("Τα πεδία με * είναι απαραίτητο να συμπληρωθούν<br>");
            out.println("&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;");
            out.println("<input class='button' id='but2' type='button' value=\"Αποθήκευση\" onclick='changeInfo();'>");
             out.println(" <input class='button' id='but4' type='button' value=\"Sign Out\" onclick='signOut();'  >");
             
        }else if("changeInfo".equals(fname)){
           String uname=request.getParameter("uname");
          User us=UserDB.getUser(uname);
                  
            String email=request.getParameter("email");
            us.setEmail(email);
            String password=request.getParameter("password");
            us.setPassword(password);
            String firstName=request.getParameter("firstname");
            us.setFirstName(firstName);
            String lastName=request.getParameter("lastname");
            us.setLastName(lastName);
            String dob=request.getParameter("dob");
            us.setBirthDate(dob);
            String gender=request.getParameter("gender");
            us.setGender(gender);
            String country=request.getParameter("country");
            us.setCountry(country);
            String city=request.getParameter("city");
            us.setTown(city);
            String info=request.getParameter("info");
            us.setInfo(info);
            UserDB.updateUser(us);
           out.println("<h3>Καλωσήρθες "+ us.getUserName()+"</h3> <br>");
           out.println("Τα στοιχεία του λογαριασμού σου είναι: <br>");
                         out.println("Username:"+ us.getUserName() +"<br>");
                        out.println("Email:"+ us.getEmail() +"<br>");
                        out.println("First Name:"+us.getFirstName() +"<br>");
                        out.println("Last Name:"+ us.getLastName() +"<br>");
                        out.println("Country:"+us.getCountry() +"<br>");
                        out.println("City:"+ us.getTown() +"<br>");
                        out.println("Date of Birth:"+us.getBirthDate() +"<br>");
                        out.println("Gender:"+ us.getGender()+"<br>");
                        out.println("Info:"+ us.getInfo() +"<br>");
                        out.println("Αλλοι Χρήστες:<br>");
                        out.println("<ul>");
                        for(int y=0;y<A.size();y++){
                            if(!email.equals(A.get(y).getEmail()) ){
                                
                                            out.println("<li>Username:"+ A.get(y).getUserName() +" &emsp; Email: "+A.get(y).getEmail()+" <input class='button' id='but6' type='button' value=\"Show my Photos\" onclick='coll_of_imgs1(\""+A.get(y).getUserName()+"\");'  ></li> ");
                            }
                        }
                        out.println("</ul>");
           out.println(" <input class='button' id='but3' type='button' value=\"Edit Account\" onclick='showAccount();'  >");
           out.println(" <input class='button' id='but4' type='button' value=\"Sign Out\" onclick='signOut();'  >");
               out.println(" <input class='button' id='but6' type='button' value=\"Show my Photos\" onclick='coll_of_imgs();'  >");
                out.println(" <input class='button' id='but7' type='button' value=\"Upload\" onclick='enableUpload();'  >");
                out.println(" <input class='button' id='but8 type='button' value=\"Delete User\" onclick='DeleteUser();'  >");
        
           
        }else if("upload".equals(fname)){
            out.println("<h3>Upload Image</h3> <br>");
            out.println("<label for='title'>Παρακαλώ Εισάγετε Τίτλο:</label> ");
            out.println("<input id='title' type='text' name='title' size='50'/>  <br>  <br>");
             out.println(" <input class='button'type=\"file\" id='but5' name=\"file\" onchange=\"UploadImage()\" multiple > <br>");
                out.println(" <input class='button' id='but8' type='button' value=\"Αρχική\" onclick='sendlogin();'  >");
        }
        else if("signOut".equals(fname)){
          
           loggedIn.clear();
            
          
          
           out.println("You have successfully signed out");
        }
            }
      
    }

  
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        processRequest(request, response);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        processRequest(request, response);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
