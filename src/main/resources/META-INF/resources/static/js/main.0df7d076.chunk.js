(window.webpackJsonp=window.webpackJsonp||[]).push([[0],{102:function(e,a,t){e.exports=t(194)},137:function(e,a,t){},138:function(e,a,t){},194:function(e,a,t){"use strict";t.r(a);t(103),t(116),t(119),t(123),t(126);var n=t(1),l=t.n(n),o=t(37),r=t.n(o),c=(t(137),t(13)),s=t(14),i=t(17),u=t(15),d=t(18),m=(t(138),t(8)),g=t(86),h=t.n(g),p=t(87),b=t.n(p),E=t(88),v=t.n(E),f=t(21),w=t(19),N=t.n(w),x=function(e){function a(e){var t;return Object(c.a)(this,a),(t=Object(i.a)(this,Object(u.a)(a).call(this,e))).state={logourl:"https://dwglogo.com/wp-content/uploads/2016/05/IBM_logo.png"},t}return Object(d.a)(a,e),Object(s.a)(a,[{key:"updateData",value:function(){var e=this;console.log("Connecting to /ui/getlogourl"),N.a.get("/ui/getlogourl").then(function(a){var t=a.data;console.log("LogoURL = "+t.logourl),e.setState(function(e,a){return{logourl:t.logourl}})}).catch(function(e){e.response?(console.log(e.response.data),console.log(e.response.status),console.log(e.response.headers)):e.request?console.log(e.request):console.log("Error",e.message)})}},{key:"componentDidMount",value:function(){this.updateData()}},{key:"render",value:function(){return l.a.createElement(m.Header,{"aria-label":"Carbon Tutorial"},l.a.createElement(m.SkipToContent,null),l.a.createElement(m.HeaderName,{element:f.b,to:"/",prefix:""},l.a.createElement("div",{className:"cpylogodiv"},l.a.createElement("img",{className:"cpylogo",src:this.state.logourl,alt:"company logo"}))),l.a.createElement(m.HeaderNavigation,{"aria-label":"ACME Demo"},l.a.createElement(m.HeaderMenuItem,{element:f.b,to:"/account"},"Account Info"),l.a.createElement(m.HeaderMenuItem,{element:f.b,to:"/tech"},"Tech Info")),l.a.createElement(m.HeaderGlobalBar,null,l.a.createElement(m.HeaderGlobalAction,{"aria-label":"Notifications"},l.a.createElement(h.a,null)),l.a.createElement(m.HeaderGlobalAction,{"aria-label":"User Avatar"},l.a.createElement(b.a,null)),l.a.createElement(m.HeaderGlobalAction,{"aria-label":"App Switcher"},l.a.createElement(v.a,null))))}}]),a}(l.a.Component),y=t(22),k=t(203),T=t(208),O=t(204),D=t(209),A=t(210),_={selected:0,triggerHref:"#",role:"navigation"},C={href:"#",role:"presentation",tabIndex:0},I=function(){return l.a.createElement("div",{className:"bx--grid bx--grid--full-width landing-page"},l.a.createElement("div",{className:"bx--row landing-page__banner"},l.a.createElement("div",{className:"bx--col-lg-16"},l.a.createElement(k.a,{noTrailingSlash:!0,"aria-label":"Page navigation"},l.a.createElement(T.a,null,l.a.createElement("a",{href:"/"},"Welcome"))),l.a.createElement("h1",{className:"landing-page__heading"},"Get your free Account"))),l.a.createElement("div",{className:"bx--row landing-page__r2"},l.a.createElement("div",{className:"bx--col bx--no-gutter"},l.a.createElement(O.a,Object.assign({},_,{"aria-label":"Tab navigation"}),l.a.createElement(D.a,Object.assign({},C,{label:"About"}),l.a.createElement("div",{className:"bx--grid bx--grid--no-gutter bx--grid--full-width"},l.a.createElement("div",{className:"bx--row landing-page__tab-content"},l.a.createElement("div",{className:"bx--col-md-4 bx--col-lg-7"},l.a.createElement("h2",{className:"landing-page__subheading"},"Free basic services"),l.a.createElement("p",{className:"landing-page__p"},"This current account is free of charge. Add optional extras if you need them. Pay only for what you use."),l.a.createElement(A.a,null,"Learn more")),l.a.createElement("div",{className:"bx--col-md-4 bx--offset-lg-1 bx--col-lg-8"},l.a.createElement("img",{className:"landing-page__illo",src:"".concat("","/banking-home.png"),alt:"Carbon illustration"}))))),l.a.createElement(D.a,Object.assign({},C,{label:"What's included ?"}),l.a.createElement("div",{className:"bx--grid bx--grid--no-gutter bx--grid--full-width"},l.a.createElement("div",{className:"bx--row landing-page__tab-content"},l.a.createElement("div",{className:"bx--col-lg-16"},"Included with our free current account Free current account online.",l.a.createElement("br",null)," All these standard services are free of charge:",l.a.createElement("ul",null,l.a.createElement("li",null,"- A debit card for making secure, fast payments in Europe"),l.a.createElement("li",null,"- Contactless payments with your card"),l.a.createElement("li",null,"- Online banking on your PC and tablet"),l.a.createElement("li",null,"- Mobile banking on your smartphone"),l.a.createElement("li",null,"- Cash withdrawals in euro at all ATMs"),l.a.createElement("li",null,"- Banking at ACME self-service terminals")))))),l.a.createElement(D.a,Object.assign({},C,{label:"PayPal"}),l.a.createElement("div",{className:"bx--grid bx--grid--no-gutter bx--grid--full-width"},l.a.createElement("div",{className:"bx--row landing-page__tab-content"},l.a.createElement("div",{className:"bx--col-lg-16"},"You can link your PayPal account with ACME Mobile and get a 24/7 view \u2013 no matter where you are \u2013 of what you've spent and what's been paid into that account. Now that's even more all-in-one convenience."))))))),l.a.createElement("div",{className:"bx--row landing-page__r3"},l.a.createElement("div",{className:"bx--col-md-4 bx--col-lg-4"},l.a.createElement("h3",{className:"landing-page__label"},"More information")),l.a.createElement("div",{className:"bx--col-md-4 bx--col-lg-4"},"Bank Card Regulations"),l.a.createElement("div",{className:"bx--col-md-4 bx--col-lg-4"},"General Banking Terms and Conditions"),l.a.createElement("div",{className:"bx--col-md-4 bx--col-lg-4"},"Fee Information Document")))},S=t(30),P=t(206),j=t(54),M=t(58),R=t(59),L=t(52),H=t(55),B=t(57),W=t(56),z=t(53),q=t(20),G=t(207),Y=function(e){var a=e.state,t=e.updateDataLoop,n=e.handlePagination;return l.a.createElement("div",null,l.a.createElement(P.a,{isSortable:!0,rows:a.rowsforpage,headers:a.headers,render:function(e){var n=e.rows,o=e.headers,r=e.getHeaderProps,c=(e.sortBy,e.getRowProps,e.getSelectionProps,e.getBatchActionProps);return e.onInputChange,e.selectedRows,l.a.createElement(j.a,{title:a.tableheader},l.a.createElement(M.a,null,l.a.createElement(R.a,null,l.a.createElement(A.a,{tabIndex:c().shouldShowBatchActions?-1:0,onClick:function(){return t()},size:"small",kind:"primary"},"Refresh"))),l.a.createElement("div",{style:{width:"100%",overflowX:"auto"}},l.a.createElement(L.a,{useZebraStyles:!0,className:"bx--data-table--short"},l.a.createElement(H.a,null,l.a.createElement(B.a,null,o.map(function(e){return l.a.createElement(W.a,Object.assign({key:e.key},r({header:e})),e.header)}))),l.a.createElement(z.a,null,n.map(function(e){return l.a.createElement(B.a,{key:e.id,className:"CR"===e.cells[4].value?"credit":"deposit"},e.cells.map(function(e){return l.a.createElement(q.a,{className:"wordwrap",key:e.id},e.value)}))})))))}}),l.a.createElement(G.a,{backwardText:"Previous page",disabled:!1,forwardText:"Next page",isLastPage:!1,itemsPerPageText:"Items per page:",onChange:function(e){return n(e)},pageInputDisabled:!1,pageNumberText:"Page Number",pageSize:a.pageSize,pageSizes:a.pageSizes,pagesUnknown:!1,totalItems:a.rows.length}))},U=function(e){function a(e){var t;return Object(c.a)(this,a),(t=Object(i.a)(this,Object(u.a)(a).call(this,e))).updateDataLoop=t.updateDataLoop.bind(Object(S.a)(t)),t.handlePagination=t.handlePagination.bind(Object(S.a)(t)),t.state={headers:[{key:"DATE",header:"DATE"},{key:"ROW",header:"ROW"},{key:"TRANS_ID",header:"TRANS_ID"},{key:"CLIENT_ID",header:"CLIENT_ID"},{key:"TYPE",header:"TYPE"},{key:"AMOUNT",header:"AMOUNT"},{key:"BALANCE",header:"BALANCE"},{key:"OPERATION",header:"OPERATION"}],rows:[],rowsforpage:[],startRow:0,endRow:10,page:1,pageSize:10,pageSizes:[10,20,50],tableheader:"My Transactions",tablerefreshloop:!1},t}return Object(d.a)(a,e),Object(s.a)(a,[{key:"handlePagination",value:function(e){var a=e.page,t=e.pageSize;if(a&&t){var n=this.state.rows.length;console.log("Page = "+a),console.log("Pagesize = "+t),console.log("Number of rows = "+n);var l=(a-1)*t,o=l+t;o>n&&(o=n),console.log("Startrow = "+l),console.log("Endrow = "+o),console.log("This is the full data : ",this.state.rows);var r=this.state.rows.slice(l,o);console.log("This is the paged data : ",r),this.setState(function(e,n){return{page:a,pageSize:t,startRow:l,endRow:o,rowsforpage:r}})}}},{key:"compare",value:function(e,a){var t=e.DATE,n=a.DATE,l=0;return t>n?l=-1:t<n&&(l=1),l}},{key:"compare2",value:function(e,a){var t=e.ROW,n=a.ROW,l=0;return t>n?l=-1:t<n&&(l=1),l}},{key:"initiateHeader",value:function(){var e=this;console.log("Connecting to /ui/getheader"),N.a.get("/ui/getheader").then(function(a){var t=a.data;console.log("Table Header = "+t.tableheader),e.setState(function(e,a){return{tableheader:t.tableheader}})}).catch(function(e){e.response?(console.log(e.response.data),console.log(e.response.status),console.log(e.response.headers)):e.request?console.log(e.request):console.log("Error",e.message)})}},{key:"updateDataLoop",value:function(){var e=this;this.interval?(clearInterval(this.interval),this.interval=null):this.interval=setInterval(function(){return e.updateData()},1e3)}},{key:"updateData",value:function(){var e=this,a="/transaction/getByAccount";console.log("Connecting to "+a),N.a.get(a).then(function(a){var t=a.data,n=0;t.sort(e.compare2),console.log("This is your sorted data ",t),t.forEach(function(e){e.id=n.toString(),"CREDIT"===e.TYPE&&(e.TYPE="CR"),"WITHDRAWAL"===e.TYPE&&(e.TYPE="WD"),"null"===e.K_SYMBOL&&(e.K_SYMBOL="");var a=new Date(e.DATE.substring(0,4),e.DATE.substring(4,5),e.DATE.substring(5,6));e.DATE=a.toDateString();var t=new Date(e.INGEST_TIME);e.INGEST_TIME=t.toUTCString(),n+=1});var l=t.slice(e.state.startRow,e.state.endRow);e.setState(function(e,a){return{rows:t,rowsforpage:l}})}).catch(function(e){e.response?(console.log(e.response.data),console.log(e.response.status),console.log(e.response.headers)):e.request?console.log(e.request):console.log("Error",e.message)})}},{key:"componentDidMount",value:function(){this.updateData(),this.initiateHeader()}},{key:"componentWillUnmount",value:function(){clearInterval(this.interval)}},{key:"render",value:function(){return l.a.createElement("div",{className:"bx--grid bx--grid--full-width bx--grid--no-gutter account-page"},l.a.createElement("div",{className:"bx--row account-page__r1"},l.a.createElement("div",{className:"accounttable bx--col-lg-16"},l.a.createElement(Y,{state:this.state,updateDataLoop:this.updateDataLoop,handlePagination:this.handlePagination}))))}}]),a}(l.a.Component),F=t(205),J=function(e){function a(e){var t;return Object(c.a)(this,a),(t=Object(i.a)(this,Object(u.a)(a).call(this,e))).state={rows:[]},t}return Object(d.a)(a,e),Object(s.a)(a,[{key:"clearMaps",value:function(){var e=this,a="/techinfo/clearmaps";console.log("Connecting to "+a),N.a.get(a).then(function(a){var t=a.data;console.log("Incoming data ",t),e.updateData()}).catch(function(e){e.response?(console.log(e.response.data),console.log(e.response.status),console.log(e.response.headers)):e.request?console.log(e.request):console.log("Error",e.message)})}},{key:"updateData",value:function(){var e=this,a="/techinfo/getoverview";console.log("Connecting to "+a),N.a.get(a).then(function(a){var t=a.data;console.log("Incoming data ",t),e.setState(function(e,a){return{rows:t}})}).catch(function(e){e.response?(console.log(e.response.data),console.log(e.response.status),console.log(e.response.headers)):e.request?console.log(e.request):console.log("Error",e.message)})}},{key:"componentDidMount",value:function(){this.updateData()}},{key:"render",value:function(){var e=this;return l.a.createElement("div",{className:"bx--grid bx--grid--full-width bx--grid--no-gutter account-page"},l.a.createElement("div",{className:"bx--row account-page__r1"},l.a.createElement("div",{className:"bx--col-lg-16 techtable"},l.a.createElement("div",{className:"bx--data-table-header"},l.a.createElement("h4",{className:"bx--data-table-header__title"},"Hazelcast IMDG Info"))),l.a.createElement("div",{className:"bx--col-lg-16 techtable"},l.a.createElement("div",{className:"refreshbutton"},l.a.createElement(A.a,{onClick:function(){return e.updateData()}},"Refresh"),l.a.createElement(A.a,{kind:"danger",onClick:function(){return e.clearMaps()}},"Clear Maps"))),l.a.createElement("div",{className:"bx--col-lg-16"},l.a.createElement(F.e,null,l.a.createElement(F.c,null,l.a.createElement(F.d,{head:!0},l.a.createElement(F.b,{head:!0},"Map Name"),l.a.createElement(F.b,{head:!0},"Map Size"),l.a.createElement(F.b,{head:!0},"Sample Content"))),l.a.createElement(F.a,null,this.state.rows.map(function(e){return l.a.createElement(F.d,{key:e.id},l.a.createElement(F.b,{noWrap:!0},e.mapname),l.a.createElement(F.b,null,e.mapcount),l.a.createElement(F.b,{className:"wordwrap"},JSON.stringify(e.mapsample)))}))))))}}]),a}(l.a.Component),K=function(e){function a(){return Object(c.a)(this,a),Object(i.a)(this,Object(u.a)(a).apply(this,arguments))}return Object(d.a)(a,e),Object(s.a)(a,[{key:"render",value:function(){return l.a.createElement(l.a.Fragment,null,l.a.createElement(x,null),l.a.createElement(m.Content,null,l.a.createElement(y.c,null,l.a.createElement(y.a,{exact:!0,path:"/",component:I}),l.a.createElement(y.a,{path:"/account",component:U}),l.a.createElement(y.a,{path:"/tech",component:J}))))}}]),a}(n.Component);Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));r.a.render(l.a.createElement(f.a,null,l.a.createElement(K,null)),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then(function(e){e.unregister()})}},[[102,1,2]]]);
//# sourceMappingURL=main.0df7d076.chunk.js.map