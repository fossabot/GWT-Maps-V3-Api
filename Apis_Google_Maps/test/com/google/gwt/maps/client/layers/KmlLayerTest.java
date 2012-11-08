package com.google.gwt.maps.client.layers;

import com.google.gwt.maps.client.AbstractMapsGWTTest;
import com.google.gwt.maps.client.LoadApi.LoadLibrary;
import com.google.gwt.maps.client.MapOptions;
import com.google.gwt.maps.client.MapTypeId;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.base.LatLngBounds;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * 
 * <br>
 * <br>
 * See <a href=
 * "https://developers.google.com/maps/documentation/javascript/layers.html#KMLLayers"
 * >KMLLayers API Doc</a>
 */
public class KmlLayerTest extends AbstractMapsGWTTest {

	@Override
	public LoadLibrary[] getLibraries() {
		return null;
	}

	public void testClose() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				String url = "http://api.flickr.com/services/feeds/geo/?g=322338@N20&lang=en-us&format=feed-georss";
				KmlLayerOptions options = KmlLayerOptions.newInstance();
				KmlLayer o = KmlLayer.newInstance(url, options);

				MapOptions mapOptions = MapOptions.newInstance();
				MapWidget left = new MapWidget(mapOptions);
				o.setMap(left);
				o.close();
				finishTest();
			}
		});

	}

	public void testClose2() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				String url = "http://api.flickr.com/services/feeds/geo/?g=322338@N20&lang=en-us&format=feed-georss";
				KmlLayerOptions options = KmlLayerOptions.newInstance();
				KmlLayer o = KmlLayer.newInstance(url, options);
				MapOptions mapOptions = MapOptions.newInstance();
				MapWidget left = new MapWidget(mapOptions);
				o.setMap(left);
				o.setMap((MapWidget) null);
				finishTest();
			}
		});

	}

	@SuppressWarnings("unused")
	public void testGetDefaultViewport() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				LatLng center = LatLng.newInstance(49.496675, -102.65625);
				MapOptions opts = MapOptions.newInstance();
				opts.setZoom(4);
				opts.setCenter(center);
				opts.setMapTypeId(MapTypeId.ROADMAP);

				MapWidget mapWidget = new MapWidget(opts);
				RootPanel.get().add(mapWidget);
				mapWidget.setSize("500px", "500px");

				String url = "http://api.flickr.com/services/feeds/geo/?g=322338@N20&lang=en-us&format=feed-georss";
				KmlLayer o = KmlLayer.newInstance(url);
				o.setMap(mapWidget);

				String left = "";
				LatLngBounds right = o.getDefaultViewport();

				// assertEquals(left, right.getToString()); // not sure why
				// right is null as of yet. I'll fish out in render testing

				finishTest();
			}
		});

	}

	@SuppressWarnings("unused")
	public void testMetadata() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				LatLng center = LatLng.newInstance(49.496675, -102.65625);
				MapOptions opts = MapOptions.newInstance();
				opts.setZoom(4);
				opts.setCenter(center);
				opts.setMapTypeId(MapTypeId.ROADMAP);

				MapWidget mapWidget = new MapWidget(opts);
				RootPanel.get().add(mapWidget);
				mapWidget.setSize("500px", "500px");

				String url = "http://api.flickr.com/services/feeds/geo/?g=322338@N20&lang=en-us&format=feed-georss";
				KmlLayer o = KmlLayer.newInstance(url);
				o.setMap(mapWidget);

				KmlLayerMetadata right = o.getMetadata();
				KmlAuthor author = right.getAuthor();
				String authName = author.getName();
				String authEmail = author.getEmail();
				String authUri = author.getUri();

				String desc = right.getDescription();
				String name = right.getName();
				String snippet = right.getSnippet();

				// I need a better link with the attributes
				// assertEquals("", authName);
				// assertEquals("", authEmail);
				// assertEquals("", authUri);
				// assertEquals("", desc);
				// assertEquals("", name);
				// assertEquals("", snippet);

				finishTest();
			}
		});

	}

	public void testUrl() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				LatLng center = LatLng.newInstance(49.496675, -102.65625);
				MapOptions opts = MapOptions.newInstance();
				opts.setZoom(4);
				opts.setCenter(center);
				opts.setMapTypeId(MapTypeId.ROADMAP);

				MapWidget mapWidget = new MapWidget(opts);
				RootPanel.get().add(mapWidget);
				mapWidget.setSize("500px", "500px");

				String url = "http://api.flickr.com/services/feeds/geo/?g=322338@N20&lang=en-us&format=feed-georss";
				KmlLayer o = KmlLayer.newInstance(url);
				o.setMap(mapWidget);

				String right = o.getUrl();
				assertEquals(url, right);

				finishTest();
			}
		});

	}

	@SuppressWarnings("unused")
	public void testUse() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				String url = "http://api.flickr.com/services/feeds/geo/?g=322338@N20&lang=en-us&format=feed-georss";
				KmlLayerOptions options = KmlLayerOptions.newInstance();
				KmlLayer o = KmlLayer.newInstance(url, options);
				finishTest();
			}
		});

	}

	public void testUse2() {
		asyncLibTest(new Runnable() {
			@Override
			public void run() {
				LatLng center = LatLng.newInstance(49.496675, -102.65625);
				MapOptions opts = MapOptions.newInstance();
				opts.setZoom(4);
				opts.setCenter(center);
				opts.setMapTypeId(MapTypeId.ROADMAP);

				MapWidget mapWidget = new MapWidget(opts);
				RootPanel.get().add(mapWidget);
				mapWidget.setSize("500px", "500px");

				String url = "http://api.flickr.com/services/feeds/geo/?g=322338@N20&lang=en-us&format=feed-georss";
				KmlLayer o = KmlLayer.newInstance(url);
				o.setMap(mapWidget);

				MapWidget right = o.getMap();
				assertEquals(mapWidget.getCenter().getToString(), right
						.getCenter().getToString());

				finishTest();
			}
		});

	}
}
