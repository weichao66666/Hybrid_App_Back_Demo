window.clickBack = function (str) {
    if(str != null && typeof str == "string") {
        if(str == "web_wrapper") {
	        document.getElementById('web_wrapper_back').click();
	    }
	}
};
window.javaInterface.back("web_wrapper");