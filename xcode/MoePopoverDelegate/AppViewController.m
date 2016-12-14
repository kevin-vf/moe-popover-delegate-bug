//
//  AppViewController.m
//  MoePopoverDelegate
//
//  Created by Kevin Tardif on 2016-12-14.
//  Copyright © 2016 My Company. All rights reserved.
//

#import "AppViewController.h"

@interface AppViewController ()

@property (weak, nonatomic) IBOutlet UIButton *shareButton;

@end

@implementation AppViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)onShareClicked:(UIButton *)sender {
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
