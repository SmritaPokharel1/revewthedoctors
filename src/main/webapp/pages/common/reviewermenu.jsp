<header class="mdl-layout__header mdl-layout__header--waterfall">

	<!-- Top row, always visible -->
	<div class="mdl-layout__header-row">
		<!-- Title -->
		<span class="mdl-layout-title">${pageTitle}</span>
		<div class="mdl-layout-spacer"></div>
		
	</div>

	<div class="mdl-layout__tab-bar mdl-js-ripple-effect">
		<a id="search-anchor" href="${pageContext.request.contextPath}/reviewer/search" class="mdl-layout__tab">Search</a> 
		<a id="review-feed-anchor" href="${pageContext.request.contextPath}/reviewer/reviewfeed" class="mdl-layout__tab">Review Feed</a>
		<a id="make-review-anchor" href="${pageContext.request.contextPath}/reviewer/makeareview" class="mdl-layout__tab">Make a review</a>
		
	</div>
</header>
 <div class="mdl-layout__drawer">
	<span class="mdl-layout-title">Examine Doctor</span>
	<nav class="mdl-navigation">
	<nav class="mdl-navigation">
     
      <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/reviewer/profile">Profile</a>
      <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/reviewer/myreviews">My Reviews</a>
      <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/main/logout">LogOut</a>
    </nav>
	</nav>
</div>