function toQuery( param ) {
	var paramArray = [];
	for( var key in param ) {
		paramArray.push( key + '=' + param[key] );
	}
	
	var query = '';
	if( paramArray.length > 0 ) {
		query = '?' + paramArray.join( '&' );
	}
	
	return query;
}
