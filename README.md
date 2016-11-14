# Data Binding implementation: step by step

This is a demo app to show how to incrementally implement data binding in an Android app.

## 1. Setup

To _activate_ data binding, you need to set at least 3 things.

 1. enable data binding inside the gradle config file.
 2. wrap your layouts with a simple `<layout>`.
 3. use the DataBindingUtil class to inflate your layout inside your activity/fragment

See the changed code here: https://github.com/oldergod/DataBindingDemo/compare/0-no-databinding...1-minimal-setup

## 2. No more `findViewById`s

With data binding activated, you can know access directly your layout views using the binding object returned from the layout inflation.
It is type safe, you are sure you did not make mistakes setting the `@id` and it also works with included layouts.

See the changed code here: https://github.com/oldergod/DataBindingDemo/compare/1-minimal-setup...2-viewbinding

## 3. One way data binding

Let's pass an object to our layout so every view is automatically filled with its corresponding data. We do not need to `view.setText()` anything anymore.
No more Null Pointer Exception! We can use resources, and some logic.

See the changed code here: https://github.com/oldergod/DataBindingDemo/compare/2-viewbinding...3-oneway-data-binding

## 4. View binding expression

We the use of the `@{}` operation, we can use java code inside the XML to add logic to our UI behavior. I.e. set a view visibility based the view model, or reuse dimensions.

See the changed code here: https://github.com/oldergod/DataBindingDemo/compare/3-oneway-data-binding...4-view-binding-expression

## 5. Data binding adapters

Here, we create a data binding adapter that would allow us to use a custom xml attribute that would use our `drawableId` and use it to set an image view.

See the changed code here: https://github.com/oldergod/DataBindingDemo/compare/4-view-binding-expression...5-binding-adapters

## 6. Persistent data binding

We use observable to allow our UI to be automatically updated when the view model changes.

See the changed code here: https://github.com/oldergod/DataBindingDemo/compare/5-binding-adapters...6-persistent-data-binding

## 7. View listeners binding method

We bind the `BottomNavigationView` and `CheckBox` event listeners in our binding adapter so we can set what function will be called on the corresponding events without boilerplate in our activity.

See the changed code here: https://github.com/oldergod/DataBindingDemo/compare/6-persistent-data-binding...7-event-listeners

## 8. Two way data binding

We transform `@{}` to `@={}` to activate two way data binding. In our case, we use it so our view model is updated everytime the checkbox is ticked and we do not need any listener anymore to do it manually.

See the changed code here: https://github.com/oldergod/DataBindingDemo/compare/7-event-listeners...8-twoway-data-binding

# Disclaimer

This does not represent all the features of the data binding library. Check the doc for more info: https://developer.android.com/topic/libraries/data-binding/index.html