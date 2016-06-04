public class MainActivity extends AppCompatActivity
	implements 
			OnMapReadyCallback, 
			GoogleMap.OnMapClickListener,
            GoogleMap.OnMarkerClickListener
    {
    
    private static final String TAG = MainActivity.class.getSimpleName();
        
    private TextView textLat, textLong;
    private MapFragment mapFragment;
    private GoogleMap map;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textLat = (TextView) findViewById(R.id.lat);
        textLong = (TextView) findViewById(R.id.lon);
        
        // initialize GoogleMaps
        initGMaps();
    }
    
    // Initialize GoogleMaps
    private void initGMaps(){
        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    } 
    
    // Callback called when Map is ready
    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d(TAG, "onMapReady()");
        map = googleMap;
        map.setOnMapClickListener(this);
        map.setOnMarkerClickListener(this);
    }
    
	// Callback called when Map is touched
    @Override
    public void onMapClick(LatLng latLng) {
        Log.d(TAG, "onMapClick("+latLng +")");
        markerForGeofence(latLng);
    }

	// Callback called when Marker is touched
    @Override
    public boolean onMarkerClick(Marker marker) {
        Log.d(TAG, "onMarkerClickListener: " + marker.getPosition() );
        return false;
    } 
}