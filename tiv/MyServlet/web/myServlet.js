/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
"use strict";

function sendAjaxGet(){
    var xhr=new XMLHttpRequest();
    document.getElementById('start').style.display = "none";
    document.getElementById('signedin').style.display = "none";
    document.getElementById('signupForm').style.display = "block";
    var fname = "signup";
    xhr.open('GET','MyServlet?function=' + fname);
    xhr.onload = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            document.getElementById('signupForm').innerHTML = xhr.responseText;
        }else if(xhr.status !== 200){
            alert('req failed returned status of' + xhr.status);
        }
    };
    xhr.send();
}

function sendInfo(){    
    var uname = document.getElementById('uname').value;
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    var vpassword = document.getElementById('vpassword').value;
    var firstname = document.getElementById('firstname').value;
    var lastname = document.getElementById('lastname').value;
    var dob = document.getElementById('dob').value;
    
    var md = MD5(password);
    
    var gender;
    if(document.getElementById('gender').checked){
        gender = document.getElementById('gender').value;
    }   
    if(document.getElementById('gender1').checked){
        gender = document.getElementById('gender1').value;
    }
    if(document.getElementById('gender2').checked){
        gender = document.getElementById('gender2').value;
    }
    var country = document.getElementById('country').value;
    var city = document.getElementById('city').value;
    var info = document.getElementById('info').value;
    
    var xhr = new XMLHttpRequest();
    var functionName = "sendInfo";
    xhr.open('POST','MyServlet');
    xhr.onload = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            document.getElementById('signupForm').innerHTML = xhr.responseText;
        }else if(xhr.status !== 200){
            alert('req failed returned status of' + xhr.status);
        }
    };
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    
    if(checkInput() && validateEmail(email) && validatePassword(password) && validateVpassword(vpassword) && validateUsername(uname) && validateFname(firstname) && validateLname(lastname) && validateCity(city) && validateInfo(info)){
    xhr.send('function=' + functionName + '&uname=' + uname + '&email=' + email + '&password=' + md + '&vpassword=' + vpassword + '&firstname=' + firstname + '&lastname=' + lastname + 
            '&dob=' + dob + '&gender=' + gender + '&country=' + country + '&city=' + city + '&info=' + info);
    }
    else{
        alert("please correct the fields where your input is wrong, or empty");
    }
}

function login(){
    document.getElementById('signedin').style.display = "block";
    document.getElementById('start').style.display = "none";
    document.getElementById('signupForm').style.display = "none";
    var xhr = new XMLHttpRequest();
    var fname = "login";
    xhr.open('GET','MyServlet?function=' + fname);
    xhr.onload = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            document.getElementById('signedin').innerHTML = xhr.responseText;
        }else if(xhr.status !== 200){
            alert('req failed returned status of' + xhr.status);
        }
    };
    xhr.send();    
}

function sendlogin(){
    document.getElementById('signedin').style.display = "none";
    document.getElementById('start').style.display = "none";
    document.getElementById('signupForm').style.display = "block";
    document.getElementById('whole').style.display = "block";
    document.getElementById('logedin').style.display = "none";
    var uname = document.getElementById('uname').value;
    var pass = document.getElementById('password').value;
    var xhr = new XMLHttpRequest();
    var fname = "sendlogin";
    xhr.open('POST','MyServlet');
    xhr.onload = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
        	document.getElementById('signupForm').innerHTML = xhr.responseText;
        }else if(xhr.status!==200){
            alert('req failed returned status of' + xhr.status);
        }
    };
    var md_login = MD5(pass);
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send('function=' + fname +'&uname=' + uname + '&password=' + md_login );    
}

function showAccount(){
    document.getElementById('signedin').style.display = "none";
    var uname = document.getElementById('uname').value;
    document.getElementById('signupForm').style.display = "block";
    var fname = "showAccount";
    
    var xhr = new XMLHttpRequest();
    xhr.open('POST','MyServlet');
    xhr.onload = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            document.getElementById('signupForm').innerHTML = xhr.responseText;
        }else if(xhr.status !== 200){
            alert('req failed returned status of' + xhr.status);
        }
    };
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send('function=' + fname +'&uname=' + uname);    
}

function changeInfo(){
    document.getElementById('signedin').style.display = "none";
    var uname = document.getElementById('uname').value;
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    var vpassword = document.getElementById('vpassword').value;
    var firstname = document.getElementById('firstname').value;
    var lastname = document.getElementById('lastname').value;
    var dob = document.getElementById('dob').value;
    var gender;
    if(document.getElementById('gender').checked){
        gender = document.getElementById('gender').value;
    }
    if(document.getElementById('gender1').checked){
        gender = document.getElementById('gender1').value;
    }
    if(document.getElementById('gender2').checked){
        gender = document.getElementById('gender2').value;
    }
    var country = document.getElementById('country').value;
    var city = document.getElementById('city').value;
    var info = document.getElementById('info').value;
    
    var xhr = new XMLHttpRequest();
    var functionName = "changeInfo";
    xhr.open('POST','MyServlet');
    xhr.onload = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            document.getElementById('signupForm').innerHTML = xhr.responseText;
        }else if(xhr.status !== 200){
            alert('req failed returned status of' + xhr.status);
        }
    };
    var md_edit = MD5(password);
    
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    checkInput();
    if(checkInput() && validateEmail(email) && validatePassword(password) && validateVpassword(vpassword) && validateUsername(uname) && validateFname(firstname) && validateLname(lastname) && validateCity(city) && validateInfo(info)){
    xhr.send('function=' + functionName + '&uname=' + uname + '&email=' + email + '&password=' + md_edit + '&vpassword=' + vpassword + '&firstname=' + firstname + '&lastname=' + lastname + 
            '&dob=' + dob + '&gender=' + gender + '&country=' + country + '&city=' + city + '&info=' + info);
    }
    else{
        alert("please correct the fields where your input is wrong, or empty");
    }
}

function signOut(){
    document.getElementById('signupForm').style.display = "none";
    document.getElementById('start').style.display = "block";
    document.getElementById('signedin').style.display = "block";
    var imageList = document.getElementById('whole');
    
    while(imageList.hasChildNodes()){
        imageList.removeChild(imageList.firstChild);
    }
    
    var map = document.getElementById('map');
    if(map.hasChildNodes()){
    	map.removeChild(map.childNodes[0]);
	}
    
    var enlarged = document.getElementById('enlarged');
    while(enlarged.hasChildNodes()){
        enlarged.removeChild(enlarged.firstChild);
    }
    
    var uname = document.getElementById('uname').value;
    var xhr = new XMLHttpRequest();
    var functionName = "signOut";
    xhr.open('POST','MyServlet');
    xhr.onload = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
           document.getElementById('welcome').innerHTML = "";
           document.getElementById('signedin').innerHTML = xhr.responseText;
        }else if(xhr.status !== 200){
            alert('req failed returned status of' + xhr.status);
        }
    };
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send('function=' + functionName + '&uname=' + uname);
}


function validateEmail(sEmail){
    var reEmail = /^(?:[\w\!\#\$\%\&\'\*\+\-\/\=\?\^\`\{\|\}\~]+\.)*[\w\!\#\$\%\&\'\*\+\-\/\=\?\^\`\{\|\}\~]+@(?:(?:(?:[a-zA-Z0-9](?:[a-zA-Z0-9\-](?!\.)){0,61}[a-zA-Z0-9]?\.)+[a-zA-Z0-9](?:[a-zA-Z0-9\-](?!$)){0,61}[a-zA-Z0-9]?)|(?:\[(?:(?:[01]?\d{1,2}|2[0-4]\d|25[0-5])\.){3}(?:[01]?\d{1,2}|2[0-4]\d|25[0-5])\]))$/;

    if(!sEmail.match(reEmail)) {
    alert("Invalid email address");
    return false;
    }
    return true;
}

function validatePassword(pass){
    var paswd =  /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,10}$/;  
    if(!pass.match(paswd)){
    alert("Invalid password form");
    return false;
    }
    return true;
}

function validateVpassword(vpass){
    var pass = document.getElementById("password").value;   

    if(!vpass.match(pass)){
            alert("Verify password is different than password");
            return false;
    }
    return true;
}
  
function validateUsername(uname){
    var ureg = /^[A-Za-z]\w{7,90}$/;

    if(!uname.match(ureg)){
            alert("invalid username form");
            alert(1);
            return false;
    }
    return true;
}

function validateFname(fname){
    var ureg = /^[A-Za-z]{3,20}$/;

    if(!fname.match(ureg)){
            alert("invalid first name form");
            return false;
    }
    return true;
}
 
function validateInfo(uinfo){
    var ureg = /^[A-Za-z]{0,500}$/;

    if(!uinfo.match(ureg)){
            alert("invalid info form");
            return false;
    }
    return true;
}
  
function validateLname(lname){
    var ureg = /^[A-Za-z]{4,20}$/;

    if(!lname.match(ureg)){
            alert("invalid last name form");
            return false;
    }
    return true;
}
  
function validateCity(ucity){
    var ureg = /^[A-Za-z]{2,50}$/;

    if(!ucity.match(ureg)){
            alert("invalid city form");
            return false;
    }
    return true;
}
  
  
function checkInput(){
    var uname = document.getElementById('uname').value;
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    var vpassword = document.getElementById('vpassword').value;
    var firstname = document.getElementById('firstname').value;
    var lastname = document.getElementById('lastname').value;
    var dob = document.getElementById('dob').value;
    var country = document.getElementById('country').value;
    var city = document.getElementById('city').value;
    if(uname.length === 0 || email.length === 0 || password.length === 0 || vpassword.length === 0 || firstname.length === 0 || lastname.length === 0 || dob.length === 0 || country.length === 0 || city.length === 0){
            return false;
    }
    return true;
}

   
var gid;

function showImage(src,id){
    if(    getRate(id)!=="0" ){
        getRatings(id);
        average(id);
    }
   gid=id;
    document.getElementById("whole").style.display = "none";
    var aver=av_rate;
    var myRate=my_rate;
    var numOfRate=num_rate;
    //Rating info 
    var rating_info = document.getElementById("rating_info");
   
    rating_info.innerHTML = ['Average rating :'  +aver+  '<br> Your rating :' + myRate+   '<br> Number of ratings :' + numOfRate+'<br>'] ;

    
    var span = document.createElement('span');
    span.innerHTML = ['<img id="img1"  src="', src,
                    ' " onclick="hideImage()"/> <pre id="allMetaDataSpan"></pre>'].join('');
    document.getElementById("enlarged").appendChild(span);
    document.getElementById("enlarged").style.display = "block";
    document.getElementById("rating").style.display = "block";

    showImageDetailedExifInfo();
}
var av_rate;
var my_rate;
var num_rate;
function average(id){
    

   
    
    var xhr = new XMLHttpRequest();
    xhr.open('POST','getMeanRate');
    xhr.onload = function(){
        if(xhr.readyState === 4 && xhr.status === 200){           
           av_rate = xhr.responseText;
        }else if(xhr.status !== 200){
           alert('req failed returned status of' + xhr.status);
        }
    };
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send('id='+id);
}

function Rate(){
var id=gid;
    var number = document.getElementById("rate").value;
    if(!number){
        return;
    }
    
    var uname = document.getElementById("uname").value;
    alert(number);
    alert(uname);
    var xhr = new XMLHttpRequest();
    xhr.open('POST','Rate');
    xhr.onload = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            alert("Your rating was submitted");
        }else if(xhr.status !== 200){
           alert('req failed returned status of' + xhr.status);
        }
    };
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send('id='+id + '&uname='+uname + '&number='+ number);    
    
}

function getRate(id){
    var uname = document.getElementById("uname").value;
    var xhr = new XMLHttpRequest();
    xhr.open('POST','getMeanRate');
    xhr.onload = function(){
        if(xhr.readyState === 4 && xhr.status === 200){           
           my_rate = xhr.responseText;
        }else if(xhr.status !== 200){
           alert('req failed returned status of' + xhr.status);
        }
    };
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send('id='+id + '&uname='+uname); 
}

function getRatings(id){
    var xhr = new XMLHttpRequest();
    xhr.open('POST','getMeanRate');
    xhr.onload = function(){
        if(xhr.readyState === 4 && xhr.status === 200){           
           num_rate = xhr.responseText;
        }else if(xhr.status !== 200){
           alert('req failed returned status of' + xhr.status);
        }
    };
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send('id='+id); 
}

function showImageDetailedExifInfo(){
    var img1 = document.getElementById("img1");
    EXIF.getData(img1, function() {
            var allMetaData = EXIF.getAllTags(this);
            var allMetaDataSpan = document.getElementById("allMetaDataSpan");
            allMetaDataSpan.innerHTML = JSON.stringify(allMetaData, null, "\t");

            var latitude = EXIF.getTag(this, "GPSLatitude");
            var latref = EXIF.getTag(this, "GPSLatitudeRef");
            var longitude = EXIF.getTag(this, "GPSLongitude");
            var longref = EXIF.getTag(this,"GPSLongitudeRef");
            if(latitude !== undefined && longitude !== undefined){
                    var ddlat = ConvertDMSToDD(latitude[0],latitude[1], latitude[2],latref); 
                    var ddlong = ConvertDMSToDD(longitude[0],longitude[1],longitude[2],longref);
                    showImageDetailedExifWithMap(ddlat,ddlong);
                    document.getElementById("map").style.display = "block";
            }
    });
}
  
function showImageDetailedExifWithMap(ddlat, ddlong){

    var img1 = document.getElementById("img1");
    document.getElementById("map").style.display = "block";
    EXIF.getData(img1, function(){
            var uluru = {lat: ddlat, lng: ddlong};
            var map = new google.maps.Map(document.getElementById('map'), {
                    zoom: 4,
                    center: uluru
            });

            var marker = new google.maps.Marker({
                    position: uluru,
                    map: map
            });
    });
}
 
function ConvertDMSToDD(degrees, minutes, seconds, direction){
    var dd = degrees + minutes/60 + seconds/(60*60);

    if (direction === "S" || direction === "W") {
        dd = dd * -1;
    } 
    return dd;
}

function hideImage(){
    var list = document.getElementById("enlarged");
    list.removeChild(list.childNodes[0]);
    document.getElementById("enlarged").style.display = "none";
    document.getElementById("rating").style.display = "none";
    document.getElementById("map").style.display = "none";
    document.getElementById("whole").style.display = "block";
}

function GetImageCollection(){
    var xhr = new XMLHttpRequest();
    var images_num = document.getElementById('images_num').value;
    var uname;
    if(document.getElementById('uname')===null){
        uname="none";
    }else{
        uname=document.getElementById('uname').value;
    } 
	
    var i;
	xhr.open('GET','GetImageCollection?user=' +uname+'&number='+images_num);
     var id;
	var my_array;
        xhr.send();
	xhr.onload = function(){
	    if(xhr.readyState === 4 && xhr.status === 200){
	    	my_array = JSON.parse(xhr.responseText);
            for(i=0; i < my_array.length; i++){
                id=my_array[i];
           
                GetImage(id);
   			}
        }
        else if(xhr.status !== 200){
    		alert('req failed returned status of' + xhr.status);
	    }
	};
	
        
}
  var dataArray;
    function getMetaFirst(id){
        
    window.URL = window.URL || window.webkitURL;
    var xhr_2 = new XMLHttpRequest();
    
		xhr_2.open('GET','GetImage?image='+id+'&metadata=true');
		xhr_2.onload = function(){
		    if(xhr_2.readyState === 4 && xhr_2.status === 200){
                         
                       dataArray = JSON.parse(xhr_2.responseText);
                       
                        
		    }else if(xhr_2.status !== 200){
		    	alert('req failed returned status of' + xhr_2.status);
		    }
		};
		xhr_2.send();
                
              
    }

function GetImage(id){	
    var base64data;  
    getMetaFirst(id);

    var xhr_1 = new XMLHttpRequest();
    xhr_1.open('GET','GetImage?image=' +id+ '&metadata=false');
    xhr_1.responseType="blob";
    xhr_1.onload = function(){
        if(xhr_1.readyState === 4 && xhr_1.status === 200){
            var blob = xhr_1.response;

            var reader = new FileReader();
            var title=dataArray.title;
            var name;
            if(document.getElementById("uname")){
                name=document.getElementById("uname").value;
            }else{
                name=dataArray.userName;
            }
            reader.readAsDataURL(blob);
            reader.onload = function() {
                base64data = reader.result;                
                var span = document.createElement('span');
                var src=window.URL.createObjectURL(blob);
                if(document.getElementById("uname")!==null){
                    span.innerHTML = ['<div class=tile> <div class="innertile"> <img id="myImg" src="', src,
				         ' " onclick="showImage(this.src, ',id,')" /> <span class="caption fade-caption">',name +' '+ title,'</span> <input class="button" id="but7" type="button" value=\"Delete\" onclick="DeleteImage(',id,');"  > </div> </div>'].join('');
                    document.getElementById('whole').insertBefore(span, null);              
                }else{
                    span.innerHTML = ['<div class=tile> <div class="innertile"> <img id="myImg" src="', src,
				         ' " onclick="showImage(this.src)" /> <span class="caption fade-caption">',name +' '+ title,'</span>  </div> </div>'].join('');
                    document.getElementById('whole').insertBefore(span, null);
                }
                        
            };
        }else if(xhr_1.status !== 200){
            alert('req failed returned status of' + xhr_1.status);
        }
    };
    xhr_1.send();
}


function coll_of_imgs(){
    var whole= document.getElementById('whole');
    document.getElementById('task3').style.display = "none";
    while(whole.hasChildNodes()){
        whole.removeChild(whole.firstChild);
    }
    GetImageCollection();

}
function enableUpload(){
    document.getElementById('start').style.display = "none";
    document.getElementById('signedin').style.display = "none";
    document.getElementById('signupForm').style.display = "none";
    document.getElementById('whole').style.display = "none";
    document.getElementById('logedin').style.display = "block";
    var xhr=new XMLHttpRequest();
	
	var fname = "upload";
	xhr.open('GET','MyServlet?function=' + fname);
	xhr.onload = function(){
	    if(xhr.readyState === 4 && xhr.status === 200){
	        document.getElementById('logedin').innerHTML = xhr.responseText;
	    }else if(xhr.status !== 200){
	        alert('req failed returned status of' + xhr.status);
	    }
	};
	xhr.send();
}
function UploadImage(){
	var	file = document.getElementById("but5").files[0]; 
	var uname = document.getElementById("uname").value;
	var title=document.getElementById("title").value;
	
	
	var formData = new FormData();
	var reader = new FileReader();
	var xhr;
	
	reader.onload = function() {
		xhr = new XMLHttpRequest();	
		formData.append('photo', file);
		xhr.open('POST', 'UploadImage?userName='+ uname +'&title='+title+'&contentType="image/jpg"');

		xhr.send(formData);
	};
	reader.readAsDataURL(file);
        alert("Η Εικόνα σας Ανέβηκε επιτυχώς");
}

function DeleteUser(){
    var uname = document.getElementById("uname").value;
    var xhr = new XMLHttpRequest();
    
    signOut();
    xhr.open('POST','DeleteUser');
    xhr.onload = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            document.getElementById('welcome').innerHTML = xhr.responseText;
        }else if(xhr.status !== 200){
            alert('req failed returned status of' + xhr.status);
        }
    };
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send('uname=' + uname);    
}

 function ClearImages(){
    var xhr = new XMLHttpRequest();
    var uname = document.getElementById('uname').value;
    var i;
    xhr.open('GET','GetImageCollection?user=' +uname+'&number=10');
    var id;
    var my_array;
    xhr.send();
    xhr.onload = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            my_array = JSON.parse(xhr.responseText);
        for(i=0; i < my_array.length; i++){
            id=my_array[i];
            DeleteImage(id);
        }
    }
    else if(xhr.status !== 200){
            alert('req failed returned status of' + xhr.status);
        }
    };
	
 }
 
 function DeleteImage(id){
    var xhr = new XMLHttpRequest();
    xhr.open('POST','DeleteImage');
    
    xhr.onload = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            alert('Photo deleted');
        }else if(xhr.status !== 200){
            alert('req failed returned status of' + xhr.status);
        }
    };
    
    xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
    xhr.send('id=' + id);
 }
 function coll_of_imgs1(uname){
      var whole= document.getElementById('whole');
    document.getElementById('task3').style.display = "none";
    while(whole.hasChildNodes()){
        whole.removeChild(whole.firstChild);
    }
    GetImageCollection1(uname);
 }
 function GetImageCollection1(uname){
    var xhr = new XMLHttpRequest();
    var images_num = document.getElementById('images_num').value;
   
 
	
    var i;
	xhr.open('GET','GetImageCollection?user=' +uname+'&number='+images_num);
     var id;
	var my_array;
        xhr.send();
	xhr.onload = function(){
	    if(xhr.readyState === 4 && xhr.status === 200){
	    	my_array = JSON.parse(xhr.responseText);
            for(i=0; i < my_array.length; i++){
                id=my_array[i];
           
                GetImage(id);
   			}
        }
        else if(xhr.status !== 200){
    		alert('req failed returned status of' + xhr.status);
	    }
	};
	
        
}
  var dataArray;
    function getMetaFirst(id){
        
    window.URL = window.URL || window.webkitURL;
    var xhr_2 = new XMLHttpRequest();
    
		xhr_2.open('GET','GetImage?image='+id+'&metadata=true');
		xhr_2.onload = function(){
		    if(xhr_2.readyState === 4 && xhr_2.status === 200){
                         
                       dataArray = JSON.parse(xhr_2.responseText);
                       
                        
		    }else if(xhr_2.status !== 200){
		    	alert('req failed returned status of' + xhr_2.status);
		    }
		};
		xhr_2.send();
                
              
    }

var MD5 = function (string) {

   function RotateLeft(lValue, iShiftBits) {
           return (lValue<<iShiftBits) | (lValue>>>(32-iShiftBits));
   }

   function AddUnsigned(lX,lY) {
           var lX4,lY4,lX8,lY8,lResult;
           lX8 = (lX & 0x80000000);
           lY8 = (lY & 0x80000000);
           lX4 = (lX & 0x40000000);
           lY4 = (lY & 0x40000000);
           lResult = (lX & 0x3FFFFFFF)+(lY & 0x3FFFFFFF);
           if (lX4 & lY4) {
                   return (lResult ^ 0x80000000 ^ lX8 ^ lY8);
           }
           if (lX4 | lY4) {
                   if (lResult & 0x40000000) {
                           return (lResult ^ 0xC0000000 ^ lX8 ^ lY8);
                   } else {
                           return (lResult ^ 0x40000000 ^ lX8 ^ lY8);
                   }
           } else {
                   return (lResult ^ lX8 ^ lY8);
           }
   }

   function F(x,y,z) { return (x & y) | ((~x) & z); }
   function G(x,y,z) { return (x & z) | (y & (~z)); }
   function H(x,y,z) { return (x ^ y ^ z); }
   function I(x,y,z) { return (y ^ (x | (~z))); }

   function FF(a,b,c,d,x,s,ac) {
           a = AddUnsigned(a, AddUnsigned(AddUnsigned(F(b, c, d), x), ac));
           return AddUnsigned(RotateLeft(a, s), b);
   };

   function GG(a,b,c,d,x,s,ac) {
           a = AddUnsigned(a, AddUnsigned(AddUnsigned(G(b, c, d), x), ac));
           return AddUnsigned(RotateLeft(a, s), b);
   };

   function HH(a,b,c,d,x,s,ac) {
           a = AddUnsigned(a, AddUnsigned(AddUnsigned(H(b, c, d), x), ac));
           return AddUnsigned(RotateLeft(a, s), b);
   };

   function II(a,b,c,d,x,s,ac) {
           a = AddUnsigned(a, AddUnsigned(AddUnsigned(I(b, c, d), x), ac));
           return AddUnsigned(RotateLeft(a, s), b);
   };

   function ConvertToWordArray(string) {
           var lWordCount;
           var lMessageLength = string.length;
           var lNumberOfWords_temp1=lMessageLength + 8;
           var lNumberOfWords_temp2=(lNumberOfWords_temp1-(lNumberOfWords_temp1 % 64))/64;
           var lNumberOfWords = (lNumberOfWords_temp2+1)*16;
           var lWordArray=Array(lNumberOfWords-1);
           var lBytePosition = 0;
           var lByteCount = 0;
           while ( lByteCount < lMessageLength ) {
                   lWordCount = (lByteCount-(lByteCount % 4))/4;
                   lBytePosition = (lByteCount % 4)*8;
                   lWordArray[lWordCount] = (lWordArray[lWordCount] | (string.charCodeAt(lByteCount)<<lBytePosition));
                   lByteCount++;
           }
           lWordCount = (lByteCount-(lByteCount % 4))/4;
           lBytePosition = (lByteCount % 4)*8;
           lWordArray[lWordCount] = lWordArray[lWordCount] | (0x80<<lBytePosition);
           lWordArray[lNumberOfWords-2] = lMessageLength<<3;
           lWordArray[lNumberOfWords-1] = lMessageLength>>>29;
           return lWordArray;
   };

   function WordToHex(lValue) {
           var WordToHexValue="",WordToHexValue_temp="",lByte,lCount;
           for (lCount = 0;lCount<=3;lCount++) {
                   lByte = (lValue>>>(lCount*8)) & 255;
                   WordToHexValue_temp = "0" + lByte.toString(16);
                   WordToHexValue = WordToHexValue + WordToHexValue_temp.substr(WordToHexValue_temp.length-2,2);
           }
           return WordToHexValue;
   };

   function Utf8Encode(string) {
           string = string.replace(/\r\n/g,"\n");
           var utftext = "";

           for (var n = 0; n < string.length; n++) {

                   var c = string.charCodeAt(n);

                   if (c < 128) {
                           utftext += String.fromCharCode(c);
                   }
                   else if((c > 127) && (c < 2048)) {
                           utftext += String.fromCharCode((c >> 6) | 192);
                           utftext += String.fromCharCode((c & 63) | 128);
                   }
                   else {
                           utftext += String.fromCharCode((c >> 12) | 224);
                           utftext += String.fromCharCode(((c >> 6) & 63) | 128);
                           utftext += String.fromCharCode((c & 63) | 128);
                   }

           }

           return utftext;
   };

   var x=Array();
   var k,AA,BB,CC,DD,a,b,c,d;
   var S11=7, S12=12, S13=17, S14=22;
   var S21=5, S22=9 , S23=14, S24=20;
   var S31=4, S32=11, S33=16, S34=23;
   var S41=6, S42=10, S43=15, S44=21;

   string = Utf8Encode(string);

   x = ConvertToWordArray(string);

   a = 0x67452301; b = 0xEFCDAB89; c = 0x98BADCFE; d = 0x10325476;

   for (k=0;k<x.length;k+=16) {
           AA=a; BB=b; CC=c; DD=d;
           a=FF(a,b,c,d,x[k+0], S11,0xD76AA478);
           d=FF(d,a,b,c,x[k+1], S12,0xE8C7B756);
           c=FF(c,d,a,b,x[k+2], S13,0x242070DB);
           b=FF(b,c,d,a,x[k+3], S14,0xC1BDCEEE);
           a=FF(a,b,c,d,x[k+4], S11,0xF57C0FAF);
           d=FF(d,a,b,c,x[k+5], S12,0x4787C62A);
           c=FF(c,d,a,b,x[k+6], S13,0xA8304613);
           b=FF(b,c,d,a,x[k+7], S14,0xFD469501);
           a=FF(a,b,c,d,x[k+8], S11,0x698098D8);
           d=FF(d,a,b,c,x[k+9], S12,0x8B44F7AF);
           c=FF(c,d,a,b,x[k+10],S13,0xFFFF5BB1);
           b=FF(b,c,d,a,x[k+11],S14,0x895CD7BE);
           a=FF(a,b,c,d,x[k+12],S11,0x6B901122);
           d=FF(d,a,b,c,x[k+13],S12,0xFD987193);
           c=FF(c,d,a,b,x[k+14],S13,0xA679438E);
           b=FF(b,c,d,a,x[k+15],S14,0x49B40821);
           a=GG(a,b,c,d,x[k+1], S21,0xF61E2562);
           d=GG(d,a,b,c,x[k+6], S22,0xC040B340);
           c=GG(c,d,a,b,x[k+11],S23,0x265E5A51);
           b=GG(b,c,d,a,x[k+0], S24,0xE9B6C7AA);
           a=GG(a,b,c,d,x[k+5], S21,0xD62F105D);
           d=GG(d,a,b,c,x[k+10],S22,0x2441453);
           c=GG(c,d,a,b,x[k+15],S23,0xD8A1E681);
           b=GG(b,c,d,a,x[k+4], S24,0xE7D3FBC8);
           a=GG(a,b,c,d,x[k+9], S21,0x21E1CDE6);
           d=GG(d,a,b,c,x[k+14],S22,0xC33707D6);
           c=GG(c,d,a,b,x[k+3], S23,0xF4D50D87);
           b=GG(b,c,d,a,x[k+8], S24,0x455A14ED);
           a=GG(a,b,c,d,x[k+13],S21,0xA9E3E905);
           d=GG(d,a,b,c,x[k+2], S22,0xFCEFA3F8);
           c=GG(c,d,a,b,x[k+7], S23,0x676F02D9);
           b=GG(b,c,d,a,x[k+12],S24,0x8D2A4C8A);
           a=HH(a,b,c,d,x[k+5], S31,0xFFFA3942);
           d=HH(d,a,b,c,x[k+8], S32,0x8771F681);
           c=HH(c,d,a,b,x[k+11],S33,0x6D9D6122);
           b=HH(b,c,d,a,x[k+14],S34,0xFDE5380C);
           a=HH(a,b,c,d,x[k+1], S31,0xA4BEEA44);
           d=HH(d,a,b,c,x[k+4], S32,0x4BDECFA9);
           c=HH(c,d,a,b,x[k+7], S33,0xF6BB4B60);
           b=HH(b,c,d,a,x[k+10],S34,0xBEBFBC70);
           a=HH(a,b,c,d,x[k+13],S31,0x289B7EC6);
           d=HH(d,a,b,c,x[k+0], S32,0xEAA127FA);
           c=HH(c,d,a,b,x[k+3], S33,0xD4EF3085);
           b=HH(b,c,d,a,x[k+6], S34,0x4881D05);
           a=HH(a,b,c,d,x[k+9], S31,0xD9D4D039);
           d=HH(d,a,b,c,x[k+12],S32,0xE6DB99E5);
           c=HH(c,d,a,b,x[k+15],S33,0x1FA27CF8);
           b=HH(b,c,d,a,x[k+2], S34,0xC4AC5665);
           a=II(a,b,c,d,x[k+0], S41,0xF4292244);
           d=II(d,a,b,c,x[k+7], S42,0x432AFF97);
           c=II(c,d,a,b,x[k+14],S43,0xAB9423A7);
           b=II(b,c,d,a,x[k+5], S44,0xFC93A039);
           a=II(a,b,c,d,x[k+12],S41,0x655B59C3);
           d=II(d,a,b,c,x[k+3], S42,0x8F0CCC92);
           c=II(c,d,a,b,x[k+10],S43,0xFFEFF47D);
           b=II(b,c,d,a,x[k+1], S44,0x85845DD1);
           a=II(a,b,c,d,x[k+8], S41,0x6FA87E4F);
           d=II(d,a,b,c,x[k+15],S42,0xFE2CE6E0);
           c=II(c,d,a,b,x[k+6], S43,0xA3014314);
           b=II(b,c,d,a,x[k+13],S44,0x4E0811A1);
           a=II(a,b,c,d,x[k+4], S41,0xF7537E82);
           d=II(d,a,b,c,x[k+11],S42,0xBD3AF235);
           c=II(c,d,a,b,x[k+2], S43,0x2AD7D2BB);
           b=II(b,c,d,a,x[k+9], S44,0xEB86D391);
           a=AddUnsigned(a,AA);
           b=AddUnsigned(b,BB);
           c=AddUnsigned(c,CC);
           d=AddUnsigned(d,DD);
   		}

   	var temp = WordToHex(a)+WordToHex(b)+WordToHex(c)+WordToHex(d);

   	return temp.toLowerCase();
};