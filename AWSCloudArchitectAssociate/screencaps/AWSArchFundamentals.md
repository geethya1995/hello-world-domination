# AWS Architecture Funadamentals
## Host Network Features
![Nitro Network Arch](/screencaps/nitroArch.png)


New feature in Nitro --> VPC Encryption

![VPC Encryption](/screencaps/vpcEncryp.png)

## AWS Data Center Network
### Regions and Availability Zones
![Regions and Availability Zones](/screencaps/availabilityZones.png)

### Large chassis based platforms
![Large chassis based platforms](/screencaps/largeChassisBased.png)
- Linecard
    - Physical ports you can attach to
- Switch fabric cards
    - To integrate linecards
- Control plane CPU (brain)
    - To cordinate all parts inside the box synchronizingly
- massive devices/complex to troubleshoot/difficult to CPU size due to large no of ports

### Single Chip based platforms
![Single Chip based platforms](/screencaps/singleChipPlatforms.png)
- modern net devices
- easy CPU sizing since you know how many ports are required when you built it

### Large Chassis VS, Single Chip based platforms
![large chassis Vs. single chip](/screencaps/image.png)

### Building Blocks of a DC network
- Blocks
    - Host racks (contains physical servers that run the AWS services)
    - Routers
    - Connectivity
    - Control Planes

- Network colors --> to recognize the generation since the switches has the same layout and looks the same
    - black - gen 1
    - blue - gen 2
    - green - gen 5 (latest)

1. Host Rack Networking
    - Partition placement --> EC instances inside a partition shares a host rack
    - Spread placement (max 7 instances) --> Individual instances has their own host rack

![Host Rack Networking](/screencaps//screencaps/image-1.png)

2. Access Cell - Attaching Host Racks
    - Top tier (ports for out of DC - north band)
    - Bottom tier (provide ports to connect host rucks)
    - Topology between tiers (device in one layer has at least one connection to all the devices in the other layer)
    - Host racks connect to two/more routers in bottom tier

![Access Cell - Attaching Host Racks](/screencaps/image-2.png)

3. Placement Group Net - Multiple Access Cells
    - spine cell (communication between access cells - Inter DC comm)

![Placement Group Net - Multiple Access Cells](/screencaps/image-4.png)

4. Cellular Net Pattern
    - core cells (provide connectivity out of DC)

![Cellular Net Pattern](/screencaps/image-3.png)

![Alt text](image.png)
### Operating a network of many devices
- Device Lifecycle (Connecting and maintaining devices)

    ![Device Lifecycle](/screencaps/image-5.png)

- Network Monitoring (Making sure everything works alright)

    ![Monitoring](/screencaps/image-6.png)

- Automated remediation/repair (Handling issues)
    - If removing the device from the network doesn't resolve the issue, the issue is raised to an engineer. Otherwise all software related remedies (Eg: Rebooting the router, restarting)

    ![Remediation](/screencaps/image-7.png)

## Availability Zones
- Scalability --> By adding more DCs
- Physically not connected (Hence, isolated)

    ![Availability Zones](image-8.png)

- AZ Topology
    - All Data Centers inside an AZ are interconnected
    - All AZs connect to Transit Center. Therefore, all AZs are interconnected
    - Transit Center (Interconnection between the AZs)
    ![AZ Topology](image-9.png)

### Building Cellular DC Arch
- Spine cells connect other DCs in other AZs (Eg: AZ-A DC1 and AZ-B DC1)

    ![Cellular DC Arch](image-10.png)

### Inter and Intra-AZ Connectivity
- Black cables --> Intra

![Cables](image-11.png)

### AWS Global Backbone
![Global Backbone](image-12.png)



### Inside an Edge POP
![Edge POP](image-13.png)