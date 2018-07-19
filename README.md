<h1>Store Dispatcher Application</h1>
<p>This application is a simulation of a consortium of stores that coordinate delivery to their customers</p>
<h2>Application Description</h2>
<p>A consortium of shops in a large city has established an agreement with local independent van and
taxi drivers to deliver products from the stores to the customer destinations. When a store gets a
product delivery order, it creates a request which is broadcast to relevant drivers within a certain
distance from the store. A driver is then assigned based on the closest driver distance to the shop
and the customer is notified that a delivery has been scheduled.</p>
<ul>
	<li>
		There 3 different kind of products 1. food (warm and frozen meals), 2. flower bouquets
		and 3. gift chocolate boxes.
	</li>
	<li>
		Some of the food products are warm and require to be kept warm during transportation, and
		some of the foods are frozen food and has to be cooled. Some of the vans have freezer on
		board so that frozen food should be assigned only to them if the delivery distance is larger
		than 2 miles
	</li>
	<li>
		If the customer has birthday and orders any kind of products, we want to deliver as a birthday
		present a chocolate boxes and a flower bouquet. This is our constrain that we want to deliver
		both chocolate and flower together.
	</li>
	<li>
		In the event of high traffic in the city (like rush hours), all frozen food should be assigned to
		the vans with freezers.
	</li>
	<p>
		Implement the main delivery assignment system. Simulate and test your application using
		random test objects of 10 drivers, 5 shops with 5 different types of products, and 10 customer
		orders and 1 high traffic event. The distance between drivers can be implemented by using a
		random integer (distance in miles),and calculate the distance ( no need to use GPS positions).
	</p>
</ul>
<h2>Implementation Details</h2>
<h4>Vehicles:</h4>
<ul>
	<li>
		Each vehicle is assigned a fixed distance from each store. At delivery job assignment time,
		the assignment system should consider the total distance.
	</li>
	<li>
		Total distance is the distance of the vehicle from the store plus the distance of the user from
		the specific store. The assignment system should consider to assign jobs to drivers with the minimum travel distance.
	</li>
	<li>
		After the vehicle is assigned, it will be marked as ”in transit” and will not be considered for
		future assignment. Till the order is delivered.
	</li>
	<li>
		The total distance of the delivery is computed based on the total travel distance.
	</li>
	<li>
		After the total distance has been traveled (one time tick = 1 mile traveled), the vehicle would
		be available for the next delivery.
	</li>
	<li>
		At delivery time, new position of the vehicle is assigned (based on the address’ distance from each store).
	</li>
</ul>
<h4>Orders:</h4>
<ul>
	<li>
		 20 orders come in at the same time in the beginning.
	</li>
	<li>
		Each order comprises of one or more item.
	</li>
	<li>
		Orders are assigned to delivery vehicles based on the vehicle with the lowest total delivery distance
		if the vehicle is available for delivery and meets all additional vehicle-type requirements.
	</li>
	<li>
		Orders are added to a list of orders that need to be scheduled when they arrive at the delivery dispatcher.
		As orders are moved to vehicles for delivery they are moved to a list of all orders in transit.  When an order
		has been delivered, the order is removed from the in transit list.
	</li>
	<li>
		If no suitable vehicles are available for delivery, the order will be temporarily skipped and all other orders will 
		be considered for delivery.  When all orders have been checked, remaining orders will again be checked for suitable vehicles.
	</li>
</ul>
<h4>Program Output</h4>
<ul>
	<li>
		Vehicles that are assigned to deliver orders or are in transit will communicate back to the dipatcher with messages about the status
		of their deliveries.  Each message will include the vehicle's identification number.
	</li>
	<li>
		Messages about orders will be displayed as a list of all the products in a given order.
	</li>
	<li>
		Vehicles will give an update to the dispatcher for every mile traveled indicating how far they've gone and how much further they need to 
		travel on the current order.
	</li>
	<li>
		When a vehilce has reached its destination, it will update dispatcher with it's new distance from each store, which will be the same as the customer's 
		distance from each store.
	</li>
</ul>
<h2>Design Considerations</h2>
<ul>
	<li>To handle the communication between several objects, I used the observer pattern in a couple places.
		The Dispatcher is the observable for several observer classes, including the vehicles and the stores.
		In addition, vehicles and stores have a reference to the dispatcher object and make frequent broadcasts to the dispatcher.
	</li>
	<li>
		To ensure that all entities are communicating with the same Dispatcher object, StoreDispatcher, as subclass of Dispatcher,
		is a Singleton object.
	</li>
	<li>
		To help with the creation of instances of several related objects, I use a factory pattern to create Store instances.
	</li>
	<li>
		I believe the use of these design patterns will help with the simplicilty and understandability of the design.
	</li>
</ul>
# Project Template

This is a Java Maven Project Template


# How to compile the project

We use Apache Maven to compile and run this project. 

You need to install Apache Maven (https://maven.apache.org/)  on your system. 

Type on the command line: 

```bash
mvn clean compile
```

# How to create a binary runnable package 


```bash
mvn clean compile assembly:single
```


# How to run


```bash
java -classpath target/Example-1-1.0-SNAPSHOT-jar-with-dependencies.jar edu.bu.met.cs665.Main
```

or


```bash
run.sh 
```

# Using Findbugs 

To see bug detail using the Findbugs GUI, use the following command "mvn findbugs:gui"

Or you can create a XML report by using  


```bash
mvn findbugs:gui 
```

or 


```bash
mvn findbugs:findbugs
```

# Run Checkstyle 

CheckStyle code styling configuration files are in config/ directory. Maven checkstyle plugin is set to use google code style. 
You can change it to other styles like sun checkstyle. 

To analyze this example using CheckStyle run 

```bash
mvn checkstyle:check
```

This will generate a report in XML format


```bash
target/checkstyle-checker.xml
target/checkstyle-result.xml
```

and the following command will generate a report in HTML format that you can open it using a Web browser. 

```bash
mvn checkstyle:checkstyle
```

```bash
target/site/checkstyle.html
```