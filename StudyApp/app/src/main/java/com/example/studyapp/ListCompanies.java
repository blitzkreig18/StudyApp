package com.example.studyapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import androidx.appcompat.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListCompanies extends AppCompatActivity {
    ListView listView;
    ArrayList<Customview> items=new ArrayList<>();
    String[] urls={ "https://www.accolite.com/",
                    "https://www.akamai.com/",
                    "https://www.altimetrik.com/",
                    "https://www.amazon.in/",
                    "https://www.atlassian.com/",
                    "https://www.capgemini.com/in-en/",
                    "https://www.capillarytech.com/",
                    "https://www.centurylink.com/",
                    "https://www.cermati.com/",
                    "https://www.cerner.com/",
                    "https://www.cohesity.com/",
                    "https://www.commvault.com/",
                    "https://www.dailyhunt.com/",
                    "https://danskeit.co.in/",
                    "https://www.dassault-aviation.com/en/",
                    "https://www.dell.com/en-in",
                    "https://www2.deloitte.com/in/en.html",
                    "https://www.ellucian.com/",
                    "https://www.finastra.com/",
                    "https://www.goldmansachs.com/",
                    "https://www.hcltech.com/",
                    "https://www.honeywell.com/us/en",
                    "https://www8.hp.com/us/en/hp-information.html",
                    "https://www.ibm.com/in-en",
                    "https://www.informatica.com/in/",
                    "https://home.kpmg/xx/en/home.html",
                    "https://www.mcafee.com/en-us/index.html",
                    "https://www.mercedes-benz.com/en/",
                    "https://www.nutanix.com/",
                    "https://www.oracle.com/index.html",
                    "https://www.philips.co.in/",
                    "https://www.publicissapient.com/",
                    "https://www.siemens.com/global/en.html",
                    "https://www.unisys.com/",
                    "https://whatfix.com/",
                    "https://www.zs.com/"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_companies);
        listView=findViewById(R.id.myList);
        items.add(new Customview("Accolite",R.drawable.accolite));
        items.add(new Customview("Akamai",R.drawable.akamai));
        items.add(new Customview("Altimetrik",R.drawable.altimetrik));
        items.add(new Customview("Amazon",R.drawable.amazon));
        items.add(new Customview("Atlassian",R.drawable.atlassian));
        items.add(new Customview("Capgemini",R.drawable.capgemini));
        items.add(new Customview("Capillary",R.drawable.capillary));
        items.add(new Customview("CenturyLink",R.drawable.centurylink));
        items.add(new Customview("Cermati",R.drawable.cermati));
        items.add(new Customview("Cerner",R.drawable.cerner));
        items.add(new Customview("Cohesity",R.drawable.cohesity));
        items.add(new Customview("Commvault",R.drawable.commvault));
        items.add(new Customview("DailyHunt",R.drawable.dailyhunt));
        items.add(new Customview("Danske",R.drawable.danske));
        items.add(new Customview("Dassault",R.drawable.dassault));
        items.add(new Customview("Dell",R.drawable.dell));
        items.add(new Customview("Delloite",R.drawable.deloitte));
        items.add(new Customview("Ellucian",R.drawable.ellucian));
        items.add(new Customview("Finastra",R.drawable.finastra));
        items.add(new Customview("Goldman Sachs",R.drawable.goldmansachs));
        items.add(new Customview("HCL",R.drawable.hcl));
        items.add(new Customview("Honeywell",R.drawable.honeywell));
        items.add(new Customview("HP",R.drawable.hp));
        items.add(new Customview("IBM",R.drawable.ibm));
        items.add(new Customview("Informatica",R.drawable.informatica));
        items.add(new Customview("KPMG",R.drawable.kpmg));
        items.add(new Customview("Mcafee",R.drawable.mcafee));
        items.add(new Customview("Mercedes Benz",R.drawable.mercedes));
        items.add(new Customview("Nutanix",R.drawable.nutanix));
        items.add(new Customview("Oracle",R.drawable.oracle));
        items.add(new Customview("Philips",R.drawable.philips));
        items.add(new Customview("Publicis Sapient",R.drawable.sapient));
        items.add(new Customview("Siemens",R.drawable.siemens));
        items.add(new Customview("Unisys",R.drawable.unisys));
        items.add(new Customview("Whatfix",R.drawable.whatfix));
        items.add(new Customview("ZS Associates",R.drawable.zs));
        listView.setAdapter(new Myadapter(ListCompanies.this, R.layout.my_list_item,items, urls));
        //1.List item layout
        //2.List item java class

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        MenuItem menuItem =menu.findItem(R.id.searchMenu);
        SearchView searchView= (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<Customview> results = new ArrayList<>();
                for(Customview x: items)
                {
                    if(x.companyname.contains(newText))
                        results.add(x);
                }
                ((Myadapter)listView.getAdapter()).update(results);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}