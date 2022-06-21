<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Add Products - SampleAPI</name>
   <tag></tag>
   <elementGuidId>92e7d461-0f5e-485c-9070-29a0dd3e504c</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;name\&quot;: \&quot;${prodName}\&quot;,\n  \&quot;price\&quot;: ${prodPrice},\n  \&quot;is_available\&quot;: ${available},\n  \&quot;seller_email\&quot;: \&quot;${sellerEmail}\&quot;,\n  \&quot;created_by\&quot;: ${createdBy}\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>c80474d6-1203-4ed8-9314-cf5d9d85f920</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>accept</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>f22d4c2c-363f-4453-a688-67c0e5aaeed2</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>8.3.5</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>http://localhost:8000/products/add</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>fb5f111a-6a8e-4b7c-9de2-23f930200405</id>
      <masked>false</masked>
      <name>prodName</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>d7da68d1-fd0f-45e8-88ea-e9677e985b1a</id>
      <masked>false</masked>
      <name>prodPrice</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>52ee70c8-1aed-4df4-b8d2-e871dac2f95e</id>
      <masked>false</masked>
      <name>available</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>a9e525e8-bb25-438a-855a-2cbaa2941122</id>
      <masked>false</masked>
      <name>sellerEmail</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>862efca6-d4c1-4d3d-989b-e6da431ead04</id>
      <masked>false</masked>
      <name>createdBy</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
