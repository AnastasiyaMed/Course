function check(formID) {
    var pattern = null;
        
    switch(formID){
        case 'name':
            pattern =  new RegExp('(^[A-Z]?[a-z]{1,15}$)|(^[А-Я]?[а-я]{1,15}$)', '');
            break;
                      
        case 'login':
            pattern =  new RegExp('(^[a-zA-Z0-9]{3,15}$)', '');
            break;              
                  
        case 'password':
            pattern =  new RegExp('^[a-zA-Z0-9_\\*\\!\\^]{6,15}$', '');
            break;                        
       
    }
        
    inputStr = document.getElementById(formID + 'Form').value;
        
    if(pattern.test(inputStr)) {
        document.getElementById(formID).style.color = 'green';
    } else {
        document.getElementById(formID).style.color = 'red';
    }
}

function clearField(msg,formID) {
    var str = document.getElementById(formID).value;
    if(str == msg)
        document.getElementById(formID).value='';
}

function restoreField(msg,formID) {
    var str = document.getElementById(formID).value;
    if(str == '')
        document.getElementById(formID).value=msg;
}

function check(formID) {
    var pattern = null;
        
    switch(formID){
        case 'name':
            pattern =  new RegExp('(^[A-Z]?[a-z]{1,15}$)|(^[А-Я]?[а-я]{1,15}$)', '');
            break;
            
        case 'surname':
            pattern =  new RegExp('(^[A-Z]?[a-z]{1,15}$)|(^[А-Я]?[а-я]{1,15}$)', '');
            break;
                      
        case 'login':
            pattern =  new RegExp('(^[a-zA-Z0-9]{3,15}$)', '');
            break;              
                  
        case 'password':
            pattern =  new RegExp('^[a-zA-Z0-9_\\*\\!\\^]{6,15}$', '');
            break;                        
       
    }
        
    inputStr = document.getElementById(formID + 'Form').value;
        
    if(pattern.test(inputStr)) {
        document.getElementById(formID).style.color = 'green';
    } else {
        document.getElementById(formID).style.color = 'red';
    }
}

function clearField(msg,formID) {
    var str = document.getElementById(formID).value;
    if(str == msg)
        document.getElementById(formID).value='';
}

function restoreField(msg,formID) {
    var str = document.getElementById(formID).value;
    if(str == '')
        document.getElementById(formID).value=msg;
}