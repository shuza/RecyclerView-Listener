<snippet>
  <content><![CDATA[
# ${Android RecyclerView Listener}

A library to use click event in recyclerView for Android

## Features
- Click Listener
- Long Click Listener

## Usage

##### Gradle
In your root build.gradle add jitpack

    allprojects {
      repositories {
        ...
        maven { url 'https://jitpack.io' }
      }
    }

In your app bulid.gradle add dependency
```
dependencies {
   compile 'com.github.shuza:RecyclerView-Listener:0.1.0'
}
```

##### Maven
In your root build.gradle add jitpack

	<repositories>
    <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
		</repository>
	</repositories>

In your app bulid.gradle add dependency

	<dependency>
	    <groupId>com.github.User</groupId>
	    <artifactId>Repo</artifactId>
	    <version>Tag</version>
	</dependency>


##### Create ViewHolder
You have to extand RootViewHolder in your view holder class

```
    public class YourViewHolder extends RootViewHolder {
        // declearation and methods
        
        public YourViewHOlder(View itemView) {
            super(itemView);
            
            // do your coding
        }
    }
```

##### Create Adapter
You have to extand RootAdapter<YourViewHolder> in you adapter class. Conustractor must call the super() method with three parameter.
- Listening class
- Layout for each row
- YourViewHolder.class

```
    public class YourAdapter extends RootAdapter<YourViewHolder> {
        public YourAdapter(RecyclerClickListener listener, int mLayout) {
            super(listener, mLayout, YourViewHolder.class);
        }
    
        @Override
        public void bindView(YourViewHolder holder, int position) {
            // display your data
        }
    
        @Override
        public int getRowCount() {
            // return size of the list
        }
    }
```

##### Using Adapter
Add YouAdapter to RecyclerView. To get Click events yuo have to implement RecyclerClickListener in your activity/fragment class

```
public class MainActivity extends AppCompatActivity implements RecyclerClickListener{
  @Override
  protected void onCreate(Bundle savedInstanceState){
    // other codes
    
    YourAdapter adapter = new YourAdapter(this, R.layout.list_item);
    
    // set this adapter to recyclserview
  }
  
  @Override
  public void onRowClickListener(int position) {
      Toast.makeText(this, position + " clicked", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onRowLongClickListener(int position) {
      Toast.makeText(this, position + " long clicked", Toast.LENGTH_SHORT).show();
  }
  
}
```


## Note

1. Extand RootViewHolder and RootAdapter
2. Must call super() in your adapter class
3. Implement RecyclerClickListener

## License
Copyright © Shalauddin Ahamad Shuza

Distributed under [MIT](https://github.com/shuza/RecyclerView-Listener/blob/master/LICENSE) license

</content>
</snippet>
