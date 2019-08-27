function ps() {
	if(this.forms.password.type = "password")
		box.innerHTML = "<input type=\"html\" name=\"password\" size=\"20\" value=" + this.forms.password.value + ">";
	click.innerHTML = "<a href=\"javascript:txt()\" class=\"iconfont icon-open-eye\"></a>"
}

function txt() {
	if(this.forms.password.type = "text")
		box.innerHTML = "<input type=\"password\" name=\"password\" size=\"20\" value=" + this.forms.password.value + ">";
	click.innerHTML = "<a href=\"javascript:ps()\" class=\"iconfont icon-biyan\"></a>"
}