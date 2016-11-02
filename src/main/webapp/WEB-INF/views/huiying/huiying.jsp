
<STYLE>
.lightfilter{ filter:light();width:400}
</STYLE>
<SCRIPT language=JavaScript>
<!--
function lightinit(){
var ix2=myDiv.offsetWidth/2;
var iy2=myDiv.offsetHeight/2;
myDiv.filters[0].addCone(0,0,1,ix2,iy2,255,255,200,100,30)} //添加一个点光源
//-->
</script>
<DIV CLASS="lightfilter" ID="myDiv" onmousemove="myDiv.filters[0].moveLight(0,window.event.x,window.event.y,5,1);">
<IMG src="images/huiying/111.jpg"></div>
<body onLoad="lightinit()">